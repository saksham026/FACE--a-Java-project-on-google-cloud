from InstagramAPI import InstagramAPI
import pandas as pd
from pandas.io.json import json_normalize
import time
import sys, json, os
import instaloader
import requests

L = instaloader.Instaloader()

# Login or load session
L.login('gupta.saksham269','Saksham026')        # (login)

profile = instaloader.Profile.from_username(L.context, sys.argv[1])

count=0
for followee in profile.get_followers():
    count=count+1

print(count)

def login_to_instagram(username, password):
    api = InstagramAPI(username, password)
    api.login()
    
    return api

api = login_to_instagram('gupta.saksham269','Saksham026')

def get_my_posts(api):
    '''Retrieve all posts from own profile'''
    my_posts = []
    has_more_posts = True
    max_id= ''

    while has_more_posts:
        api.getSelfUserFeed(maxid=max_id)
        if api.LastJson['more_available'] is not True:
            has_more_posts = False #stop condition

        max_id = api.LastJson.get('next_max_id','')
        my_posts.extend(api.LastJson['items']) #merge lists
        time.sleep(2) # slows down to avoid flooding

        #if has_more_posts:
            #print(str(len(my_posts)) + ' posts retrieved so far...')

    #print('Total posts retrieved: ' + str(len(my_posts)))
    
    return my_posts

my_posts = get_my_posts(api)

def get_posts_likers(api, my_posts):
    '''Retrieve all likers on all posts'''
    
    likers = []
    
    #print('wait %.1f minutes' % (len(my_posts)*2/60.))
    for i in range(len(my_posts)):
        m_id = my_posts[i]['id']
        api.getMediaLikers(m_id)
        
        likers += [api.LastJson]
        
        # Include post_id in likers dict list
        likers[i]['post_id'] = m_id
        
        time.sleep(2)
    #print('done')
    
    return likers


likers = get_posts_likers(api, my_posts)

def get_posts_commenters(api, my_posts):
    '''Retrieve all commenters on all posts '''
    
    commenters = []
    
    #print('wait %.1f minutes' % (len(my_posts)*2/60.))
    for i in range(len(my_posts)):
        m_id = my_posts[i]['id']
        api.getMediaComments(m_id)
        
        commenters += [api.LastJson]
        
        # Include post_id in commenters dict list
        commenters[i]['post_id'] = m_id
            
        time.sleep(2)
    #print('done')
    
    return commenters

commenters = get_posts_commenters(api, my_posts)

def get_their_posts(api, user_id):
    '''Retrieve all posts from someone else's profile'''
    their_posts = []
    has_more_posts = True
    max_id= ''

    while has_more_posts:
        api.getUserFeed(user_id, maxid=max_id)
        if api.LastJson['more_available'] is not True:
            has_more_posts = False #stop condition

    max_id = api.LastJson.get('next_max_id','')
    their_posts.extend(api.LastJson['items']) #merge lists
    time.sleep(2) # slows down to avoid flooding

    #if has_more_posts:
        #print(str(len(their_posts)) + ' posts retrieved so far...')

    #print('Total posts retrieved: ' + str(len(their_posts)))

    return their_posts

def get_id(username):
	url = "https://www.instagram.com/web/search/topsearch/?context=blended&query="+username+"&rank_token=0.3953592318270893&count=1"
	response = requests.get(url)
	respJSON = response.json()
	try:
		user_id = str( respJSON['users'][0].get("user").get("pk") )
		return user_id
	except:
		return "Unexpected error"

user_id = get_id(sys.argv[1])

their_posts = get_their_posts(api,user_id)

likers = get_posts_likers(api, their_posts)

def posts_likers_to_df(likers):
    '''Transforms likers list of dicts into pandas DataFrame'''
    
    # Normalize likers by getting the 'users' list and the post_id of each like
    df_likers = json_normalize(likers, 'users', ['post_id'])
    
    # Add 'content_type' column to know the rows are likes
    df_likers['content_type'] = 'like'
    
    return df_likers

df_likers = posts_likers_to_df(likers)

print(str(df_likers.shape[0])) #shape[0] represents number of rows

