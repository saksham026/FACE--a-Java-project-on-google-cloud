CREATE DATABASE  IF NOT EXISTS `database` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `database`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: database
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acting_role_types`
--

DROP TABLE IF EXISTS `acting_role_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acting_role_types` (
  `e_id` int(11) DEFAULT NULL,
  `lead_actor` varchar(10) DEFAULT NULL,
  `lead_support` varchar(10) DEFAULT NULL,
  `supporting_actor` varchar(10) DEFAULT NULL,
  `junior_artist` varchar(10) DEFAULT NULL,
  `cameo` varchar(10) DEFAULT NULL,
  `other` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acting_role_types`
--

LOCK TABLES `acting_role_types` WRITE;
/*!40000 ALTER TABLE `acting_role_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `acting_role_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `all_post`
--

DROP TABLE IF EXISTS `all_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `all_post` (
  `e_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `type_of_post` varchar(20) DEFAULT NULL,
  `date_of_post` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `all_post`
--

LOCK TABLES `all_post` WRITE;
/*!40000 ALTER TABLE `all_post` DISABLE KEYS */;
INSERT INTO `all_post` VALUES (1,1,'investment','2020-03-30'),(1,2,'investment','2020-03-30'),(1,3,'investment','2020-03-30'),(1,4,'investment','2020-03-30'),(1,5,'investment','2020-03-31');
/*!40000 ALTER TABLE `all_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `basic_profile`
--

DROP TABLE IF EXISTS `basic_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `basic_profile` (
  `e_id` int(11) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `public_whatsapp_number` int(11) DEFAULT NULL,
  `public_calling_number` int(11) DEFAULT NULL,
  `public_email_id` varchar(30) DEFAULT NULL,
  `private_whatsapp_number` int(11) DEFAULT NULL,
  `private_calling_number` int(11) DEFAULT NULL,
  `private_email_id` varchar(30) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `home_town` varchar(20) DEFAULT NULL,
  `current_location` varchar(20) DEFAULT NULL,
  `indian_nationality` varchar(20) DEFAULT NULL,
  `foreigner_nationality` varchar(20) DEFAULT NULL,
  `personal_profile_photo` longblob,
  `baisc_profile_detail_image` longblob,
  `about_me` varchar(2000) DEFAULT NULL,
  `type_of_entity` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basic_profile`
--

LOCK TABLES `basic_profile` WRITE;
/*!40000 ALTER TABLE `basic_profile` DISABLE KEYS */;
INSERT INTO `basic_profile` VALUES (1,'fn','ln',1234567859,17891,'s@hbk',4536,74889,'shjs@h','2009-01-01','m','ss','loc','india','for',NULL,NULL,'sss','investor'),(2,'ss','ss',1234,NULL,NULL,NULL,NULL,NULL,NULL,'Male',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'actor');
/*!40000 ALTER TABLE `basic_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `body_attributes_profile`
--

DROP TABLE IF EXISTS `body_attributes_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `body_attributes_profile` (
  `eid` int(11) DEFAULT NULL,
  `extremely_fair` varchar(10) DEFAULT 'No',
  `fair` varchar(10) DEFAULT 'No',
  `wheatish` varchar(10) DEFAULT 'No',
  `dark` varchar(10) DEFAULT 'No',
  `other_skin_tone` varchar(10) DEFAULT 'No',
  `straight_hair` varchar(10) DEFAULT 'No',
  `wavy_hair` varchar(10) DEFAULT 'No',
  `curly_hair` varchar(10) DEFAULT 'No',
  `other_type_hair` varchar(10) DEFAULT 'No',
  `thin_volume_hair` varchar(10) DEFAULT 'No',
  `thick_volume_hair` varchar(10) DEFAULT 'No',
  `normal_volume_hair` varchar(10) DEFAULT 'No',
  `monolids_eyes` varchar(10) DEFAULT 'No',
  `round_eyes` varchar(10) DEFAULT 'No',
  `almond_eyes` varchar(10) DEFAULT 'No',
  `downturned_eyes` varchar(10) DEFAULT 'No',
  `upturned_eyes` varchar(10) DEFAULT 'No',
  `hooded_eyes` varchar(10) DEFAULT 'No',
  `other_type_eyes` varchar(10) DEFAULT 'No',
  `height` int(11) DEFAULT '0',
  `weight` int(11) DEFAULT '0',
  `hips` int(11) DEFAULT '0',
  `waist` int(11) DEFAULT '0',
  `shoulders` int(11) DEFAULT '0',
  `chest_or_bust` int(11) DEFAULT '0',
  `skinny_body` varchar(10) DEFAULT 'No',
  `avg_physique_body` varchar(10) DEFAULT 'No',
  `muscular_body` varchar(10) DEFAULT 'No',
  `fat_body` varchar(10) DEFAULT 'No',
  `plus_size_body` varchar(10) DEFAULT 'No',
  `body_attributes_profile_detail_image` longblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `body_attributes_profile`
--

LOCK TABLES `body_attributes_profile` WRITE;
/*!40000 ALTER TABLE `body_attributes_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `body_attributes_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrer_profile`
--

DROP TABLE IF EXISTS `carrer_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrer_profile` (
  `e_id` int(11) DEFAULT NULL,
  `instagram_followers` int(11) DEFAULT NULL,
  `carrer_profile_project_detail_image` longblob,
  `carrer_profile_honor_award_detail_image` longblob,
  `carrer_profile_prganisation_associated_with_detail_image` longblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrer_profile`
--

LOCK TABLES `carrer_profile` WRITE;
/*!40000 ALTER TABLE `carrer_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrer_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrer_profile_honor_award`
--

DROP TABLE IF EXISTS `carrer_profile_honor_award`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrer_profile_honor_award` (
  `e_id` int(11) DEFAULT NULL,
  `carrer_profile_honor_award_id` int(11) DEFAULT NULL,
  `honor_award_title` varchar(200) DEFAULT NULL,
  `honor_award_associated_with` varchar(3000) DEFAULT NULL,
  `honor_award_issuer` varchar(200) DEFAULT NULL,
  `honor_award_date` date DEFAULT NULL,
  `honor_award_description` varchar(3000) DEFAULT NULL,
  `honor_award_website_link` varchar(255) DEFAULT NULL,
  `honor_award_instgram_link` varchar(255) DEFAULT NULL,
  `honor_award_facebook_link` varchar(255) DEFAULT NULL,
  `honor_award_twitter_link` varchar(255) DEFAULT NULL,
  `honor_award_other_link` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrer_profile_honor_award`
--

LOCK TABLES `carrer_profile_honor_award` WRITE;
/*!40000 ALTER TABLE `carrer_profile_honor_award` DISABLE KEYS */;
INSERT INTO `carrer_profile_honor_award` VALUES (2,2,'abcdvgv','we,rt','ertt','2009-01-01','wert','fdch','gvjh','fjvj','xytu','ftcfghj'),(2,3,'abcdvgv','we,rt','ertt','2009-01-01','wert','fdch','gvjh','fjvj','xytu','ftcfghj'),(2,4,'abcdvgv','we,rt','ertt','2009-01-01','wert','fdch','gvjh','fjvj','xytu','ftcfghj');
/*!40000 ALTER TABLE `carrer_profile_honor_award` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrer_profile_media`
--

DROP TABLE IF EXISTS `carrer_profile_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrer_profile_media` (
  `e_id` int(11) DEFAULT NULL,
  `carrer_profile_id` int(11) DEFAULT NULL,
  `carrer_profile_type` varchar(30) DEFAULT NULL,
  `media_id` int(11) DEFAULT NULL,
  `media` longblob,
  `media_type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrer_profile_media`
--

LOCK TABLES `carrer_profile_media` WRITE;
/*!40000 ALTER TABLE `carrer_profile_media` DISABLE KEYS */;
INSERT INTO `carrer_profile_media` VALUES (1,1,'carrer_profile_project',1,NULL,NULL);
/*!40000 ALTER TABLE `carrer_profile_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrer_profile_organisation_associated_with`
--

DROP TABLE IF EXISTS `carrer_profile_organisation_associated_with`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrer_profile_organisation_associated_with` (
  `e_id` int(11) DEFAULT NULL,
  `organisation_associated_with_id` int(11) DEFAULT NULL,
  `organisation_associated_with_name` varchar(200) DEFAULT NULL,
  `organisation_associated_with_position` varchar(200) DEFAULT NULL,
  `organisation_associated_with_start_date` date DEFAULT NULL,
  `organisation_associated_with_end_date` date DEFAULT NULL,
  `organisation_associated_with_description` varchar(3000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrer_profile_organisation_associated_with`
--

LOCK TABLES `carrer_profile_organisation_associated_with` WRITE;
/*!40000 ALTER TABLE `carrer_profile_organisation_associated_with` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrer_profile_organisation_associated_with` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrer_profile_project`
--

DROP TABLE IF EXISTS `carrer_profile_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrer_profile_project` (
  `e_id` int(11) DEFAULT NULL,
  `carrer_profile_project_id` int(11) DEFAULT NULL,
  `project_name` varchar(30) DEFAULT NULL,
  `project_start_date` date DEFAULT NULL,
  `project_end_date` date DEFAULT NULL,
  `project_organisation_associated_with` varchar(3000) DEFAULT NULL,
  `project_cast_associated_with` varchar(3000) DEFAULT NULL,
  `project_website_link` varchar(255) DEFAULT NULL,
  `project_instgram_link` varchar(255) DEFAULT NULL,
  `project_facebook_link` varchar(255) DEFAULT NULL,
  `project_twitter_link` varchar(255) DEFAULT NULL,
  `project_other_link` varchar(255) DEFAULT NULL,
  `project_description` varchar(3000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrer_profile_project`
--

LOCK TABLES `carrer_profile_project` WRITE;
/*!40000 ALTER TABLE `carrer_profile_project` DISABLE KEYS */;
INSERT INTO `carrer_profile_project` VALUES (1,2,'try1','2009-01-01','2009-01-01','face1,face2,face3','abc','wl','il','fl','tl','ol','desc'),(1,3,'try1','2009-01-01','2009-01-01','face1,face2,face3','abc','wl','il','fl','tl','ol','desc'),(1,4,'try1','2009-01-01','2009-01-01','face1,face2,face3','abc','wl','il','fl','tl','ol','desc');
/*!40000 ALTER TABLE `carrer_profile_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collaboration_services_for_which_project`
--

DROP TABLE IF EXISTS `collaboration_services_for_which_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collaboration_services_for_which_project` (
  `e_id` int(11) DEFAULT NULL,
  `feature_film` varchar(10) DEFAULT NULL,
  `short_film` varchar(10) DEFAULT NULL,
  `web_series` varchar(10) DEFAULT NULL,
  `tv_series` varchar(10) DEFAULT NULL,
  `documentary_series` varchar(10) DEFAULT NULL,
  `movie_commercial` varchar(10) DEFAULT NULL,
  `tv_commercial` varchar(10) DEFAULT NULL,
  `web_commercial` varchar(10) DEFAULT NULL,
  `music_album_or_video` varchar(10) DEFAULT NULL,
  `theatre_or_musical_or_stage_shows` varchar(10) DEFAULT NULL,
  `stand_up_comedy_event` varchar(10) DEFAULT NULL,
  `fashion_or_style_or_beauty_event` varchar(10) DEFAULT NULL,
  `lifestyle_event` varchar(10) DEFAULT NULL,
  `food_event` varchar(10) DEFAULT NULL,
  `fitness_event` varchar(10) DEFAULT NULL,
  `health_event` varchar(10) DEFAULT NULL,
  `travel_event` varchar(10) DEFAULT NULL,
  `gaming_or_tech_event` varchar(10) DEFAULT NULL,
  `cultural_or_social_event` varchar(10) DEFAULT NULL,
  `wedding_event` varchar(10) DEFAULT NULL,
  `party_event` varchar(10) DEFAULT NULL,
  `magazine_photoshoot_event` varchar(10) DEFAULT NULL,
  `billboard_photoshoot_event` varchar(10) DEFAULT NULL,
  `campaign_photoshoot_event` varchar(10) DEFAULT NULL,
  `booklets_photoshoot_event` varchar(10) DEFAULT NULL,
  `flyers_photoshoot_event` varchar(10) DEFAULT NULL,
  `posters_photoshoot_event` varchar(10) DEFAULT NULL,
  `other_photoshoot_event` varchar(10) DEFAULT NULL,
  `glitz_modelling_event` varchar(10) DEFAULT NULL,
  `semi_glitz_modelling_event` varchar(10) DEFAULT NULL,
  `natural_modelling_event` varchar(10) DEFAULT NULL,
  `other_modelling_event` varchar(10) DEFAULT NULL,
  `acting_competition_event` varchar(10) DEFAULT NULL,
  `dance_competition_event` varchar(10) DEFAULT NULL,
  `music_competition_event` varchar(10) DEFAULT NULL,
  `other_competition_event` varchar(10) DEFAULT NULL,
  `other_event` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collaboration_services_for_which_project`
--

LOCK TABLES `collaboration_services_for_which_project` WRITE;
/*!40000 ALTER TABLE `collaboration_services_for_which_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `collaboration_services_for_which_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comedy_types`
--

DROP TABLE IF EXISTS `comedy_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comedy_types` (
  `e_id` int(11) DEFAULT NULL,
  `observation` varchar(10) DEFAULT NULL,
  `anecdotal` varchar(10) DEFAULT NULL,
  `situational` varchar(10) DEFAULT NULL,
  `character_type` varchar(10) DEFAULT NULL,
  `one_liner` varchar(10) DEFAULT NULL,
  `ironic` varchar(10) DEFAULT NULL,
  `deadpan` varchar(10) DEFAULT NULL,
  `slapstick` varchar(10) DEFAULT NULL,
  `self_deprecating` varchar(10) DEFAULT NULL,
  `farcical` varchar(10) DEFAULT NULL,
  `other` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comedy_types`
--

LOCK TABLES `comedy_types` WRITE;
/*!40000 ALTER TABLE `comedy_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `comedy_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dance_types`
--

DROP TABLE IF EXISTS `dance_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dance_types` (
  `e_id` int(11) DEFAULT NULL,
  `bollywood` varchar(10) DEFAULT NULL,
  `ballet` varchar(10) DEFAULT NULL,
  `break_dance` varchar(10) DEFAULT NULL,
  `belly` varchar(10) DEFAULT NULL,
  `tango` varchar(10) DEFAULT NULL,
  `salsa` varchar(10) DEFAULT NULL,
  `bhangra` varchar(10) DEFAULT NULL,
  `classical` varchar(10) DEFAULT NULL,
  `tap` varchar(10) DEFAULT NULL,
  `jazz` varchar(10) DEFAULT NULL,
  `lyrical` varchar(10) DEFAULT NULL,
  `hip_hop` varchar(10) DEFAULT NULL,
  `contempory` varchar(10) DEFAULT NULL,
  `arial` varchar(10) DEFAULT NULL,
  `bolly_hop_fusion` varchar(10) DEFAULT NULL,
  `urban_bhangra_fusion` varchar(10) DEFAULT NULL,
  `other_fusion` varchar(10) DEFAULT NULL,
  `other` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dance_types`
--

LOCK TABLES `dance_types` WRITE;
/*!40000 ALTER TABLE `dance_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `dance_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favourite_face`
--

DROP TABLE IF EXISTS `favourite_face`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favourite_face` (
  `user_id` int(11) DEFAULT NULL,
  `face_id` int(11) DEFAULT NULL,
  `type_of_face` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favourite_face`
--

LOCK TABLES `favourite_face` WRITE;
/*!40000 ALTER TABLE `favourite_face` DISABLE KEYS */;
INSERT INTO `favourite_face` VALUES (1,2,'actor');
/*!40000 ALTER TABLE `favourite_face` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favourite_post`
--

DROP TABLE IF EXISTS `favourite_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favourite_post` (
  `user_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `type_of_post` varchar(30) DEFAULT NULL,
  `post_owner_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favourite_post`
--

LOCK TABLES `favourite_post` WRITE;
/*!40000 ALTER TABLE `favourite_post` DISABLE KEYS */;
INSERT INTO `favourite_post` VALUES (1,4,'investment',1);
/*!40000 ALTER TABLE `favourite_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrument_types`
--

DROP TABLE IF EXISTS `instrument_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instrument_types` (
  `e_id` int(11) DEFAULT NULL,
  `keyboard` varchar(10) DEFAULT NULL,
  `piano` varchar(10) DEFAULT NULL,
  `accoustic_guitar` varchar(10) DEFAULT NULL,
  `electric_guitar` varchar(10) DEFAULT NULL,
  `other_guitar` varchar(10) DEFAULT NULL,
  `drums` varchar(10) DEFAULT NULL,
  `violin` varchar(10) DEFAULT NULL,
  `saxophone` varchar(10) DEFAULT NULL,
  `flulte` varchar(10) DEFAULT NULL,
  `celio` varchar(10) DEFAULT NULL,
  `clarinet` varchar(10) DEFAULT NULL,
  `other` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrument_types`
--

LOCK TABLES `instrument_types` WRITE;
/*!40000 ALTER TABLE `instrument_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `instrument_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investment_services_for_which_project`
--

DROP TABLE IF EXISTS `investment_services_for_which_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `investment_services_for_which_project` (
  `e_id` int(11) DEFAULT NULL,
  `feature_film` varchar(10) DEFAULT NULL,
  `short_film` varchar(10) DEFAULT NULL,
  `web_series` varchar(10) DEFAULT NULL,
  `tv_series` varchar(10) DEFAULT NULL,
  `documentary_series` varchar(10) DEFAULT NULL,
  `movie_commercial` varchar(10) DEFAULT NULL,
  `tv_commercial` varchar(10) DEFAULT NULL,
  `web_commercial` varchar(10) DEFAULT NULL,
  `music_album_or_video` varchar(10) DEFAULT NULL,
  `theatre_or_musical_or_stage_shows` varchar(10) DEFAULT NULL,
  `stand_up_comedy_event` varchar(10) DEFAULT NULL,
  `fashion_or_style_or_beauty_event` varchar(10) DEFAULT NULL,
  `lifestyle_event` varchar(10) DEFAULT NULL,
  `food_event` varchar(10) DEFAULT NULL,
  `fitness_event` varchar(10) DEFAULT NULL,
  `health_event` varchar(10) DEFAULT NULL,
  `travel_event` varchar(10) DEFAULT NULL,
  `gaming_or_tech_event` varchar(10) DEFAULT NULL,
  `cultural_or_social_event` varchar(10) DEFAULT NULL,
  `wedding_event` varchar(10) DEFAULT NULL,
  `party_event` varchar(10) DEFAULT NULL,
  `magazine_photoshoot_event` varchar(10) DEFAULT NULL,
  `billboard_photoshoot_event` varchar(10) DEFAULT NULL,
  `campaign_photoshoot_event` varchar(10) DEFAULT NULL,
  `booklets_photoshoot_event` varchar(10) DEFAULT NULL,
  `flyers_photoshoot_event` varchar(10) DEFAULT NULL,
  `posters_photoshoot_event` varchar(10) DEFAULT NULL,
  `other_photoshoot_event` varchar(10) DEFAULT NULL,
  `glitz_modelling_event` varchar(10) DEFAULT NULL,
  `semi_glitz_modelling_event` varchar(10) DEFAULT NULL,
  `natural_modelling_event` varchar(10) DEFAULT NULL,
  `other_modelling_event` varchar(10) DEFAULT NULL,
  `acting_competition_event` varchar(10) DEFAULT NULL,
  `dance_competition_event` varchar(10) DEFAULT NULL,
  `music_competition_event` varchar(10) DEFAULT NULL,
  `other_competition_event` varchar(10) DEFAULT NULL,
  `other_event` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investment_services_for_which_project`
--

LOCK TABLES `investment_services_for_which_project` WRITE;
/*!40000 ALTER TABLE `investment_services_for_which_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `investment_services_for_which_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelling_types`
--

DROP TABLE IF EXISTS `modelling_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelling_types` (
  `e_id` int(11) DEFAULT NULL,
  `fashion` varchar(10) DEFAULT NULL,
  `runaway` varchar(10) DEFAULT NULL,
  `swimsuit` varchar(10) DEFAULT NULL,
  `lingerie` varchar(10) DEFAULT NULL,
  `commercial` varchar(10) DEFAULT NULL,
  `fitness` varchar(10) DEFAULT NULL,
  `print` varchar(10) DEFAULT NULL,
  `glamour` varchar(10) DEFAULT NULL,
  `promotional` varchar(10) DEFAULT NULL,
  `hand_parts` varchar(10) DEFAULT NULL,
  `arm_parts` varchar(10) DEFAULT NULL,
  `feet_parts` varchar(10) DEFAULT NULL,
  `legs_parts` varchar(10) DEFAULT NULL,
  `other_parts` varchar(10) DEFAULT NULL,
  `other_modelling` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelling_types`
--

LOCK TABLES `modelling_types` WRITE;
/*!40000 ALTER TABLE `modelling_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `modelling_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music_types`
--

DROP TABLE IF EXISTS `music_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `music_types` (
  `e_id` int(11) DEFAULT NULL,
  `musical_theatre` varchar(10) DEFAULT NULL,
  `jazz` varchar(10) DEFAULT NULL,
  `rock` varchar(10) DEFAULT NULL,
  `classical` varchar(10) DEFAULT NULL,
  `hip_hop` varchar(10) DEFAULT NULL,
  `fusion` varchar(10) DEFAULT NULL,
  `pop` varchar(10) DEFAULT NULL,
  `bollywood` varchar(10) DEFAULT NULL,
  `religious` varchar(10) DEFAULT NULL,
  `electronic` varchar(10) DEFAULT NULL,
  `disco` varchar(10) DEFAULT NULL,
  `other` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music_types`
--

LOCK TABLES `music_types` WRITE;
/*!40000 ALTER TABLE `music_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `music_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `office_profile`
--

DROP TABLE IF EXISTS `office_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `office_profile` (
  `e_id` int(11) DEFAULT NULL,
  `_name` varchar(30) DEFAULT NULL,
  `whatsapp_number` int(11) DEFAULT NULL,
  `calling_number` int(11) DEFAULT NULL,
  `email_id` varchar(30) DEFAULT NULL,
  `website_link` varchar(255) DEFAULT NULL,
  `instgram_link` varchar(255) DEFAULT NULL,
  `facebook_link` varchar(255) DEFAULT NULL,
  `twitter_link` varchar(255) DEFAULT NULL,
  `other_link` varchar(255) DEFAULT NULL,
  `about_us` varchar(2000) DEFAULT NULL,
  `plot_or_building_number` int(11) DEFAULT NULL,
  `building_name` varchar(30) DEFAULT NULL,
  `floor_number` int(11) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `locality` varchar(30) DEFAULT NULL,
  `landmark` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `google_map_link` varchar(30) DEFAULT NULL,
  `logo` longblob,
  `communication_profile_photo` longblob,
  `office_profile_detail_image` longblob,
  `office_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `office_profile`
--

LOCK TABLES `office_profile` WRITE;
/*!40000 ALTER TABLE `office_profile` DISABLE KEYS */;
INSERT INTO `office_profile` VALUES (1,'sghvhg',1187278,27359,'s@mb','sbsk.com','il','fl','tl','other','abjdk',5,'skbsk',3,'street','locality','lmark','city','stte',123,'india','gmaplink',NULL,NULL,NULL,1),(1,'sghvhg',1187278,27359,'s@mb','sbsk.com','il','fl','tl','other','abjdk',5,'skbsk',3,'street','locality','lmark','city','stte',123,'india','gmaplink',NULL,NULL,NULL,2),(1,'sghvhg',1187278,27359,'s@mb','sbsk.com','il','fl','tl','other','abjdk',5,'skbsk',3,'street','locality','lmark','city','stte',123,'india','gmaplink',NULL,NULL,NULL,3);
/*!40000 ALTER TABLE `office_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_post`
--

DROP TABLE IF EXISTS `project_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_post` (
  `e_id` int(11) DEFAULT NULL,
  `project_post_id` int(11) DEFAULT NULL,
  `type_of_post` varchar(25) DEFAULT NULL,
  `project_name` varchar(10) DEFAULT NULL,
  `organiser_name` varchar(10) DEFAULT NULL,
  `language_of_project` varchar(10) DEFAULT NULL,
  `shoot_location` varchar(10) DEFAULT NULL,
  `shoot_start_date` date DEFAULT NULL,
  `shoot_end_date` date DEFAULT NULL,
  `shoot_time` time DEFAULT NULL,
  `budget_min_value` int(11) DEFAULT NULL,
  `budget_max_value` int(11) DEFAULT NULL,
  `other_means_of_budget` varchar(10) DEFAULT NULL,
  `note` varchar(10) DEFAULT NULL,
  `feature_film` varchar(10) DEFAULT 'No',
  `short_film` varchar(10) DEFAULT 'No',
  `web_series` varchar(10) DEFAULT 'No',
  `tv_series` varchar(10) DEFAULT 'No',
  `documentary_series` varchar(10) DEFAULT 'No',
  `movie_commercial` varchar(10) DEFAULT 'No',
  `tv_commercial` varchar(10) DEFAULT 'No',
  `web_commercial` varchar(10) DEFAULT 'No',
  `music_album_or_video` varchar(10) DEFAULT 'No',
  `theatre_or_musical_or_stage_shows` varchar(10) DEFAULT 'No',
  `stand_up_comedy_event` varchar(10) DEFAULT 'No',
  `fashion_or_style_or_beauty_event` varchar(10) DEFAULT 'No',
  `lifestyle_event` varchar(10) DEFAULT 'No',
  `food_event` varchar(10) DEFAULT 'No',
  `fitness_event` varchar(10) DEFAULT 'No',
  `health_event` varchar(10) DEFAULT 'No',
  `travel_event` varchar(10) DEFAULT 'No',
  `gaming_or_tech_event` varchar(10) DEFAULT 'No',
  `cultural_or_social_event` varchar(10) DEFAULT 'No',
  `wedding_event` varchar(10) DEFAULT 'No',
  `party_event` varchar(10) DEFAULT 'No',
  `magazine_photoshoot_event` varchar(10) DEFAULT 'No',
  `billboard_photoshoot_event` varchar(10) DEFAULT 'No',
  `campaign_photoshoot_event` varchar(10) DEFAULT 'No',
  `booklets_photoshoot_event` varchar(10) DEFAULT 'No',
  `flyers_photoshoot_event` varchar(10) DEFAULT 'No',
  `posters_photoshoot_event` varchar(10) DEFAULT 'No',
  `other_photoshoot_event` varchar(10) DEFAULT 'No',
  `glitz_modelling_event` varchar(10) DEFAULT 'No',
  `semi_glitz_modelling_event` varchar(10) DEFAULT 'No',
  `natural_modelling_event` varchar(10) DEFAULT 'No',
  `other_modelling_event` varchar(10) DEFAULT 'No',
  `acting_competition_event` varchar(10) DEFAULT 'No',
  `dance_competition_event` varchar(10) DEFAULT 'No',
  `music_competition_event` varchar(10) DEFAULT 'No',
  `other_competition_event` varchar(10) DEFAULT 'No',
  `other_event` varchar(30) DEFAULT 'No',
  `executive_producer` varchar(10) DEFAULT NULL,
  `line_producer` varchar(10) DEFAULT NULL,
  `supervising_producer` varchar(10) DEFAULT NULL,
  `co_producer` varchar(10) DEFAULT NULL,
  `co_ordinating_producer` varchar(10) DEFAULT NULL,
  `primary_associate_or_assistant_producer` varchar(10) DEFAULT NULL,
  `secondary_associate_or_assistant_producer` varchar(10) DEFAULT NULL,
  `other_associate_or_assistant_producer` varchar(10) DEFAULT NULL,
  `segment_producer` varchar(10) DEFAULT NULL,
  `event_producer` varchar(10) DEFAULT NULL,
  `music_producer` varchar(10) DEFAULT NULL,
  `film_director` varchar(10) DEFAULT NULL,
  `primary_associate_film_director` varchar(10) DEFAULT NULL,
  `secondary_associate_film_director` varchar(10) DEFAULT NULL,
  `other_associate_film_director` varchar(10) DEFAULT NULL,
  `casting_director` varchar(10) DEFAULT NULL,
  `primary_associate_casting_director` varchar(10) DEFAULT NULL,
  `secondary_associate_casting_director` varchar(10) DEFAULT NULL,
  `other_associate_casting_director` varchar(10) DEFAULT NULL,
  `music_director` varchar(10) DEFAULT NULL,
  `primary_associate_music_director` varchar(10) DEFAULT NULL,
  `secondary_associate_music_director` varchar(10) DEFAULT NULL,
  `other_associate_music_director` varchar(10) DEFAULT NULL,
  `dop` varchar(10) DEFAULT NULL,
  `primary_camera_operator` varchar(10) DEFAULT NULL,
  `secondary_camera_operator` varchar(10) DEFAULT NULL,
  `other_camera_operator` varchar(10) DEFAULT NULL,
  `gafer` varchar(10) DEFAULT NULL,
  `best_boy` varchar(10) DEFAULT NULL,
  `lighting_technician_or_grip` varchar(10) DEFAULT NULL,
  `film_video_editor` varchar(10) DEFAULT NULL,
  `sound_designer` varchar(10) DEFAULT NULL,
  `dialouge_editor` varchar(10) DEFAULT NULL,
  `foley_artist` varchar(10) DEFAULT NULL,
  `language_translator` varchar(10) DEFAULT NULL,
  `language_tutor` varchar(10) DEFAULT NULL,
  `fashion_stylist` varchar(10) DEFAULT NULL,
  `hair_makeup_stylist` varchar(10) DEFAULT NULL,
  `illustrator` varchar(10) DEFAULT NULL,
  `graphic_artist` varchar(10) DEFAULT NULL,
  `production_designer` varchar(10) DEFAULT NULL,
  `art_director` varchar(10) DEFAULT NULL,
  `set_designer` varchar(10) DEFAULT NULL,
  `set_dressor` varchar(10) DEFAULT NULL,
  `set_constructor` varchar(10) DEFAULT NULL,
  `script_writter` varchar(10) DEFAULT NULL,
  `script_supervisor` varchar(10) DEFAULT NULL,
  `finance_manager` varchar(10) DEFAULT NULL,
  `location_manager` varchar(10) DEFAULT NULL,
  `scout` varchar(10) DEFAULT NULL,
  `primary_assistant_location_manager` varchar(10) DEFAULT NULL,
  `secondary_assistant_location_manager` varchar(10) DEFAULT NULL,
  `other_assistant_location_manager` varchar(10) DEFAULT NULL,
  `primary_production_manager` varchar(10) DEFAULT NULL,
  `secondary_production_manager` varchar(10) DEFAULT NULL,
  `other_production_manager` varchar(10) DEFAULT NULL,
  `unit_publicist` varchar(10) DEFAULT NULL,
  `legal_counsel` varchar(10) DEFAULT NULL,
  `system_adminstrator` varchar(10) DEFAULT NULL,
  `event_manager` varchar(10) DEFAULT NULL,
  `of_any_other_entity` varchar(10) DEFAULT NULL,
  `actor` varchar(10) DEFAULT NULL,
  `model` varchar(10) DEFAULT NULL,
  `dancer` varchar(10) DEFAULT NULL,
  `singer` varchar(10) DEFAULT NULL,
  `insrumentalist` varchar(10) DEFAULT NULL,
  `composer` varchar(10) DEFAULT NULL,
  `music_engineer` varchar(10) DEFAULT NULL,
  `radio_or_voice_over` varchar(10) DEFAULT NULL,
  `dj` varchar(10) DEFAULT NULL,
  `band` varchar(10) DEFAULT NULL,
  `stand_up_comedian` varchar(10) DEFAULT NULL,
  `other_type_of_entity` varchar(10) DEFAULT NULL,
  `male_number` int(11) DEFAULT NULL,
  `female_number` int(11) DEFAULT NULL,
  `transgender_number` int(11) DEFAULT NULL,
  `other_number_gender` int(11) DEFAULT NULL,
  `home_town` varchar(20) DEFAULT NULL,
  `current_location` varchar(20) DEFAULT NULL,
  `indian_nationality` varchar(20) DEFAULT NULL,
  `foreigner_nationality` varchar(20) DEFAULT NULL,
  `extremely_fair` varchar(10) DEFAULT NULL,
  `fair` varchar(10) DEFAULT NULL,
  `wheatish` varchar(10) DEFAULT NULL,
  `dark` varchar(10) DEFAULT NULL,
  `other_skin_tone` varchar(10) DEFAULT NULL,
  `straight_hair` varchar(10) DEFAULT NULL,
  `wavy_hair` varchar(10) DEFAULT NULL,
  `curly_hair` varchar(10) DEFAULT NULL,
  `other_type_hair` varchar(10) DEFAULT NULL,
  `thin_volume_hair` varchar(10) DEFAULT NULL,
  `thick_volume_hair` varchar(10) DEFAULT NULL,
  `normal_volume_hair` varchar(10) DEFAULT NULL,
  `monolids_eyes` varchar(10) DEFAULT NULL,
  `round_eyes` varchar(10) DEFAULT NULL,
  `almond_eyes` varchar(10) DEFAULT NULL,
  `downturned_eyes` varchar(10) DEFAULT NULL,
  `upturned_eyes` varchar(10) DEFAULT NULL,
  `hooded_eyes` varchar(10) DEFAULT NULL,
  `other_type_eyes` varchar(10) DEFAULT NULL,
  `height_min` int(11) DEFAULT NULL,
  `height_max` int(11) DEFAULT NULL,
  `weight_min` int(11) DEFAULT NULL,
  `weight_max` int(11) DEFAULT NULL,
  `hips_min` int(11) DEFAULT NULL,
  `hips_max` int(11) DEFAULT NULL,
  `waist_min` int(11) DEFAULT NULL,
  `waist_max` int(11) DEFAULT NULL,
  `shoulders_min` int(11) DEFAULT NULL,
  `shoulders_max` int(11) DEFAULT NULL,
  `chest_min` int(11) DEFAULT NULL,
  `chest_max` int(11) DEFAULT NULL,
  `bust_min` int(11) DEFAULT NULL,
  `bust_max` int(11) DEFAULT NULL,
  `skinny_body` varchar(10) DEFAULT NULL,
  `avg_physique_body` varchar(10) DEFAULT NULL,
  `muscular_body` varchar(10) DEFAULT NULL,
  `fat_body` varchar(10) DEFAULT NULL,
  `plus_size_body` varchar(10) DEFAULT NULL,
  `pleasant_appearance` varchar(10) DEFAULT NULL,
  `hot` varchar(10) DEFAULT NULL,
  `villager` varchar(10) DEFAULT NULL,
  `upmarket` varchar(10) DEFAULT NULL,
  `cute` varchar(10) DEFAULT NULL,
  `goodlooking` varchar(10) DEFAULT NULL,
  `expressive_eyes` varchar(10) DEFAULT NULL,
  `bright_smile` varchar(10) DEFAULT NULL,
  `other_characteristics` varchar(10) DEFAULT NULL,
  `online_audition_end_date` date DEFAULT NULL,
  `online_audition_end_time` varchar(20) DEFAULT NULL,
  `online_audition_script` varchar(3000) DEFAULT NULL,
  `offline_audition_start_date` date DEFAULT NULL,
  `offline_audition_end_date` date DEFAULT NULL,
  `offline_audition_start_time` varchar(20) DEFAULT NULL,
  `offline_audition_end_time` varchar(20) DEFAULT NULL,
  `offline_audition_script` varchar(3000) DEFAULT NULL,
  `project_post_detail_image` longblob,
  `online_audition_start_date` varchar(20) DEFAULT NULL,
  `online_audition_start_time` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_post`
--

LOCK TABLES `project_post` WRITE;
/*!40000 ALTER TABLE `project_post` DISABLE KEYS */;
INSERT INTO `project_post` VALUES (1,2,'investment_project_post',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,'No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,2,'investment_project_post',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,'No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,3,'investment_project_post',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,'No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,4,'investment_project_post',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,'No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,5,'investment_project_post','abcd',NULL,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,'No','Yes','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No','No',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2009-01-01','1 pm','ss',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `project_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_schedular`
--

DROP TABLE IF EXISTS `project_schedular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_schedular` (
  `e_id` int(11) DEFAULT NULL,
  `project_post_id` int(11) DEFAULT NULL,
  `date_of_project` date DEFAULT NULL,
  `time_of_project` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_schedular`
--

LOCK TABLES `project_schedular` WRITE;
/*!40000 ALTER TABLE `project_schedular` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_schedular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotional_post`
--

DROP TABLE IF EXISTS `promotional_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotional_post` (
  `e_id` int(11) DEFAULT NULL,
  `promotional_post_id` int(11) DEFAULT NULL,
  `type_of_post` varchar(25) DEFAULT NULL,
  `_name` varchar(20) DEFAULT NULL,
  `_by` varchar(100) DEFAULT NULL,
  `start_time` varchar(20) DEFAULT NULL,
  `end_time` varchar(20) DEFAULT NULL,
  `venue_plot_or_building_number` int(11) DEFAULT NULL,
  `venue_building_name` varchar(30) DEFAULT NULL,
  `venue_floor_number` int(11) DEFAULT NULL,
  `venue_street` varchar(30) DEFAULT NULL,
  `venue_locality` varchar(30) DEFAULT NULL,
  `venue_landmark` varchar(30) DEFAULT NULL,
  `venue_city` varchar(30) DEFAULT NULL,
  `venue_state` varchar(30) DEFAULT NULL,
  `venue_pincode` int(11) DEFAULT NULL,
  `venue_country` varchar(30) DEFAULT NULL,
  `venue_google_map_link` varchar(30) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `other_details` varchar(2000) DEFAULT NULL,
  `promotional_post_detail_image` longblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotional_post`
--

LOCK TABLES `promotional_post` WRITE;
/*!40000 ALTER TABLE `promotional_post` DISABLE KEYS */;
INSERT INTO `promotional_post` VALUES (1,1,'class_promotional_post','aa','by','6pm',NULL,23,'building name',2,'street','locla','land','city','state',24,'country','gmaplink','2009-01-01',NULL,'other',NULL),(1,1,'class_promotional_post','aa','by','6pm','6pm',23,'building name',2,'street','locla','land','city','state',24,'country','gmaplink','2009-01-01','2009-01-01','other',NULL);
/*!40000 ALTER TABLE `promotional_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotional_project_schedular`
--

DROP TABLE IF EXISTS `promotional_project_schedular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotional_project_schedular` (
  `e_id` int(11) DEFAULT NULL,
  `promotional_post_id` int(11) DEFAULT NULL,
  `date_of_promotional_project` date DEFAULT NULL,
  `time_of_promotional_project` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotional_project_schedular`
--

LOCK TABLES `promotional_project_schedular` WRITE;
/*!40000 ALTER TABLE `promotional_project_schedular` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotional_project_schedular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `type_of_post` varchar(30) DEFAULT NULL,
  `status_` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (1,1,5,'investment','Accepted');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `response` (
  `user_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `type_of_post` varchar(30) DEFAULT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  `status_` varchar(20) DEFAULT NULL,
  `audition_uploaded` longblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response`
--

LOCK TABLES `response` WRITE;
/*!40000 ALTER TABLE `response` DISABLE KEYS */;
INSERT INTO `response` VALUES (2,5,'investment',1,'applied',NULL);
/*!40000 ALTER TABLE `response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sample_post_product_media`
--

DROP TABLE IF EXISTS `sample_post_product_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sample_post_product_media` (
  `e_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `type_of_post` varchar(25) DEFAULT NULL,
  `sample_product_media_id` int(11) DEFAULT NULL,
  `sample_product_media` longblob,
  `sample_product_media_type` varchar(20) DEFAULT NULL,
  `media_description` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample_post_product_media`
--

LOCK TABLES `sample_post_product_media` WRITE;
/*!40000 ALTER TABLE `sample_post_product_media` DISABLE KEYS */;
INSERT INTO `sample_post_product_media` VALUES (1,5,'investment_project_post',1,NULL,NULL,'Aa'),(1,6,'investment_project_post',1,NULL,NULL,'Aa');
/*!40000 ALTER TABLE `sample_post_product_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scoreboard`
--

DROP TABLE IF EXISTS `scoreboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scoreboard` (
  `e_id` int(11) DEFAULT NULL,
  `type_of_profile` varchar(20) DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scoreboard`
--

LOCK TABLES `scoreboard` WRITE;
/*!40000 ALTER TABLE `scoreboard` DISABLE KEYS */;
/*!40000 ALTER TABLE `scoreboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `search_history`
--

DROP TABLE IF EXISTS `search_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `search_history` (
  `e_id` int(11) DEFAULT NULL,
  `search_element` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `search_history`
--

LOCK TABLES `search_history` WRITE;
/*!40000 ALTER TABLE `search_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `search_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semi_nude_shoot_or_dress_for_which_projects`
--

DROP TABLE IF EXISTS `semi_nude_shoot_or_dress_for_which_projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semi_nude_shoot_or_dress_for_which_projects` (
  `e_id` int(11) DEFAULT NULL,
  `feature_film` varchar(10) DEFAULT NULL,
  `short_film` varchar(10) DEFAULT NULL,
  `web_series` varchar(10) DEFAULT NULL,
  `tv_series` varchar(10) DEFAULT NULL,
  `documentary_series` varchar(10) DEFAULT NULL,
  `movie_commercial` varchar(10) DEFAULT NULL,
  `tv_commercial` varchar(10) DEFAULT NULL,
  `web_commercial` varchar(10) DEFAULT NULL,
  `music_album_or_video` varchar(10) DEFAULT NULL,
  `theatre_or_musical_or_stage_shows` varchar(10) DEFAULT NULL,
  `stand_up_comedy_event` varchar(10) DEFAULT NULL,
  `fashion_or_style_or_beauty_event` varchar(10) DEFAULT NULL,
  `lifestyle_event` varchar(10) DEFAULT NULL,
  `food_event` varchar(10) DEFAULT NULL,
  `fitness_event` varchar(10) DEFAULT NULL,
  `health_event` varchar(10) DEFAULT NULL,
  `travel_event` varchar(10) DEFAULT NULL,
  `gaming_or_tech_event` varchar(10) DEFAULT NULL,
  `cultural_or_social_event` varchar(10) DEFAULT NULL,
  `wedding_event` varchar(10) DEFAULT NULL,
  `party_event` varchar(10) DEFAULT NULL,
  `magazine_photoshoot_event` varchar(10) DEFAULT NULL,
  `billboard_photoshoot_event` varchar(10) DEFAULT NULL,
  `campaign_photoshoot_event` varchar(10) DEFAULT NULL,
  `booklets_photoshoot_event` varchar(10) DEFAULT NULL,
  `flyers_photoshoot_event` varchar(10) DEFAULT NULL,
  `posters_photoshoot_event` varchar(10) DEFAULT NULL,
  `other_photoshoot_event` varchar(10) DEFAULT NULL,
  `glitz_modelling_event` varchar(10) DEFAULT NULL,
  `semi_glitz_modelling_event` varchar(10) DEFAULT NULL,
  `natural_modelling_event` varchar(10) DEFAULT NULL,
  `other_modelling_event` varchar(10) DEFAULT NULL,
  `acting_competition_event` varchar(10) DEFAULT NULL,
  `dance_competition_event` varchar(10) DEFAULT NULL,
  `music_competition_event` varchar(10) DEFAULT NULL,
  `other_competition_event` varchar(10) DEFAULT NULL,
  `other_event` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semi_nude_shoot_or_dress_for_which_projects`
--

LOCK TABLES `semi_nude_shoot_or_dress_for_which_projects` WRITE;
/*!40000 ALTER TABLE `semi_nude_shoot_or_dress_for_which_projects` DISABLE KEYS */;
/*!40000 ALTER TABLE `semi_nude_shoot_or_dress_for_which_projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `e_id` int(11) DEFAULT NULL,
  `investment` varchar(10) DEFAULT NULL,
  `collaboration` varchar(10) DEFAULT NULL,
  `worker_as_an_artist` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'yes','yes','yes'),(1,'yes','yes','yes'),(1,NULL,NULL,NULL),(1,NULL,NULL,NULL),(1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talent_profile_media`
--

DROP TABLE IF EXISTS `talent_profile_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `talent_profile_media` (
  `e_id` int(11) DEFAULT NULL,
  `media_id` int(11) DEFAULT NULL,
  `media` longblob,
  `media_type` varchar(20) DEFAULT NULL,
  `media_description` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talent_profile_media`
--

LOCK TABLES `talent_profile_media` WRITE;
/*!40000 ALTER TABLE `talent_profile_media` DISABLE KEYS */;
/*!40000 ALTER TABLE `talent_profile_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_of_profile`
--

DROP TABLE IF EXISTS `type_of_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_of_profile` (
  `e_id` int(11) DEFAULT NULL,
  `executive_producer` varchar(10) DEFAULT 'NO',
  `line_producer` varchar(10) DEFAULT 'NO',
  `supervising_producer` varchar(10) DEFAULT 'NO',
  `co_producer` varchar(10) DEFAULT 'NO',
  `co_ordinating_producer` varchar(10) DEFAULT 'NO',
  `primary_associate_or_assistant_producer` varchar(10) DEFAULT 'NO',
  `secondary_associate_or_assistant_producer` varchar(10) DEFAULT 'NO',
  `other_associate_or_assistant_producer` varchar(10) DEFAULT 'NO',
  `segment_producer` varchar(10) DEFAULT 'NO',
  `event_producer` varchar(10) DEFAULT 'NO',
  `music_producer` varchar(10) DEFAULT 'NO',
  `film_director` varchar(10) DEFAULT 'NO',
  `primary_associate_film_director` varchar(10) DEFAULT 'NO',
  `secondary_associate_film_director` varchar(10) DEFAULT 'NO',
  `other_associate_film_director` varchar(10) DEFAULT 'NO',
  `casting_director` varchar(10) DEFAULT 'NO',
  `primary_associate_casting_director` varchar(10) DEFAULT 'NO',
  `secondary_associate_casting_director` varchar(10) DEFAULT 'NO',
  `other_associate_casting_director` varchar(10) DEFAULT 'NO',
  `music_director` varchar(10) DEFAULT 'NO',
  `primary_associate_music_director` varchar(10) DEFAULT 'NO',
  `secondary_associate_music_director` varchar(10) DEFAULT 'NO',
  `other_associate_music_director` varchar(10) DEFAULT 'NO',
  `dop` varchar(10) DEFAULT 'NO',
  `primary_camera_operator` varchar(10) DEFAULT 'NO',
  `secondary_camera_operator` varchar(10) DEFAULT 'NO',
  `other_camera_operator` varchar(10) DEFAULT 'NO',
  `gafer` varchar(10) DEFAULT 'NO',
  `best_boy` varchar(10) DEFAULT 'NO',
  `lighting_technician_or_grip` varchar(10) DEFAULT 'NO',
  `film_video_editor` varchar(10) DEFAULT 'NO',
  `sound_designer` varchar(10) DEFAULT 'NO',
  `dialouge_editor` varchar(10) DEFAULT 'NO',
  `foley_artist` varchar(10) DEFAULT 'NO',
  `language_translator` varchar(10) DEFAULT 'NO',
  `language_tutor` varchar(10) DEFAULT 'NO',
  `fashion_stylist` varchar(10) DEFAULT 'NO',
  `hair_makeup_stylist` varchar(10) DEFAULT 'NO',
  `illustrator` varchar(10) DEFAULT 'NO',
  `graphic_artist` varchar(10) DEFAULT 'NO',
  `production_designer` varchar(10) DEFAULT 'NO',
  `art_director` varchar(10) DEFAULT 'NO',
  `set_designer` varchar(10) DEFAULT 'NO',
  `set_dressor` varchar(10) DEFAULT 'NO',
  `set_constructor` varchar(10) DEFAULT 'NO',
  `script_writter` varchar(10) DEFAULT 'NO',
  `script_supervisor` varchar(10) DEFAULT 'NO',
  `finance_manager` varchar(10) DEFAULT 'NO',
  `location_manager` varchar(10) DEFAULT 'NO',
  `scout` varchar(10) DEFAULT 'NO',
  `primary_assistant_location_manager` varchar(10) DEFAULT 'NO',
  `secondary_assistant_location_manager` varchar(10) DEFAULT 'NO',
  `other_assistant_location_manager` varchar(10) DEFAULT 'NO',
  `primary_production_manager` varchar(10) DEFAULT 'NO',
  `secondary_production_manager` varchar(10) DEFAULT 'NO',
  `other_production_manager` varchar(10) DEFAULT 'NO',
  `unit_publicist` varchar(10) DEFAULT 'NO',
  `legal_counsel` varchar(10) DEFAULT 'NO',
  `system_adminstrator` varchar(10) DEFAULT 'NO',
  `event_manager` varchar(10) DEFAULT 'NO',
  `of_any_other_entity` varchar(10) DEFAULT 'NO',
  `actor` varchar(10) DEFAULT 'NO',
  `model` varchar(10) DEFAULT 'NO',
  `dancer` varchar(10) DEFAULT 'NO',
  `singer` varchar(10) DEFAULT 'NO',
  `insrumentalist` varchar(10) DEFAULT 'NO',
  `composer` varchar(10) DEFAULT 'NO',
  `music_engineer` varchar(10) DEFAULT 'NO',
  `radio_or_voice_over` varchar(10) DEFAULT 'NO',
  `dj` varchar(10) DEFAULT 'NO',
  `band` varchar(10) DEFAULT 'NO',
  `stand_up_comedian` varchar(10) DEFAULT 'NO',
  `other_type` varchar(10) DEFAULT 'NO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_of_profile`
--

LOCK TABLES `type_of_profile` WRITE;
/*!40000 ALTER TABLE `type_of_profile` DISABLE KEYS */;
INSERT INTO `type_of_profile` VALUES (1,'yes','NO','NO','NO','NO','NO','NO','NO','NO','yes','yes','yes','NO','NO','NO','yes','NO','NO','NO','NO','NO','NO','NO','NO','yes','NO','NO','NO','yes','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','yes','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','NO','yes','NO','NO','NO','yes','NO','yes','NO','NO','NO','NO','NO');
/*!40000 ALTER TABLE `type_of_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker_as_an_artist_services_for_which_project`
--

DROP TABLE IF EXISTS `worker_as_an_artist_services_for_which_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worker_as_an_artist_services_for_which_project` (
  `e_id` int(11) DEFAULT NULL,
  `feature_film` varchar(10) DEFAULT NULL,
  `short_film` varchar(10) DEFAULT NULL,
  `web_series` varchar(10) DEFAULT NULL,
  `tv_series` varchar(10) DEFAULT NULL,
  `documentary_series` varchar(10) DEFAULT NULL,
  `movie_commercial` varchar(10) DEFAULT NULL,
  `tv_commercial` varchar(10) DEFAULT NULL,
  `web_commercial` varchar(10) DEFAULT NULL,
  `music_album_or_video` varchar(10) DEFAULT NULL,
  `theatre_or_musical_or_stage_shows` varchar(10) DEFAULT NULL,
  `stand_up_comedy_event` varchar(10) DEFAULT NULL,
  `fashion_or_style_or_beauty_event` varchar(10) DEFAULT NULL,
  `lifestyle_event` varchar(10) DEFAULT NULL,
  `food_event` varchar(10) DEFAULT NULL,
  `fitness_event` varchar(10) DEFAULT NULL,
  `health_event` varchar(10) DEFAULT NULL,
  `travel_event` varchar(10) DEFAULT NULL,
  `gaming_or_tech_event` varchar(10) DEFAULT NULL,
  `cultural_or_social_event` varchar(10) DEFAULT NULL,
  `wedding_event` varchar(10) DEFAULT NULL,
  `party_event` varchar(10) DEFAULT NULL,
  `magazine_photoshoot_event` varchar(10) DEFAULT NULL,
  `billboard_photoshoot_event` varchar(10) DEFAULT NULL,
  `campaign_photoshoot_event` varchar(10) DEFAULT NULL,
  `booklets_photoshoot_event` varchar(10) DEFAULT NULL,
  `flyers_photoshoot_event` varchar(10) DEFAULT NULL,
  `posters_photoshoot_event` varchar(10) DEFAULT NULL,
  `other_photoshoot_event` varchar(10) DEFAULT NULL,
  `glitz_modelling_event` varchar(10) DEFAULT NULL,
  `semi_glitz_modelling_event` varchar(10) DEFAULT NULL,
  `natural_modelling_event` varchar(10) DEFAULT NULL,
  `other_modelling_event` varchar(10) DEFAULT NULL,
  `acting_competition_event` varchar(10) DEFAULT NULL,
  `dance_competition_event` varchar(10) DEFAULT NULL,
  `music_competition_event` varchar(10) DEFAULT NULL,
  `other_competition_event` varchar(10) DEFAULT NULL,
  `other_event` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_as_an_artist_services_for_which_project`
--

LOCK TABLES `worker_as_an_artist_services_for_which_project` WRITE;
/*!40000 ALTER TABLE `worker_as_an_artist_services_for_which_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `worker_as_an_artist_services_for_which_project` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-13 11:22:54
