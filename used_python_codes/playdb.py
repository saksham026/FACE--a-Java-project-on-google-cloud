from playsound import playsound
#playsound('alarm_sound.mp3')


from pydub import AudioSegment
from pydub.playback import play

#song = AudioSegment.from_wav("grandfather.wav")
#play(song)

from Tkinter import *
import tkSnack

root = Tk()
tkSnack.initializeSnack(root)

snd = tkSnack.Sound()
snd.read('grandfather.wav')
snd.play(blocking=1)

import os

file = "alarm_sound.mp3"
#os.system("mpg123 " + file)
