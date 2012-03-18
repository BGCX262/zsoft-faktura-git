-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Vert: localhost
-- Generert den: 18. Mar, 2012 13:51 
-- Tjenerversjon: 5.5.8
-- PHP-Versjon: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ims`
--

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `t_user`
--

CREATE TABLE IF NOT EXISTS `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tlf` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=65 ;

--
-- Dataark for tabell `t_user`
--

INSERT INTO `t_user` (`user_id`, `email`, `enabled`, `full_name`, `password`, `tlf`, `user_name`) VALUES
(61, 'mehdi@mehdi.com', '1', 'Mehdi Zare', '55', '', 'mehdi'),
(64, 'arash', '1', 'arash', 'arash', NULL, 'arash');

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `t_userroles`
--

CREATE TABLE IF NOT EXISTS `t_roles` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dataark for tabell `t_userroles`
--

INSERT INTO `t_roles` (`role_id`, `authority`) VALUES
(11, 'ROLE_IRAN'),
(13, 'ROLE_ADMIN'),
(14, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `t_user_roles`
--

CREATE TABLE IF NOT EXISTS `t_user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK309FDDF43C17FF19` (`role_id`),
  KEY `FK309FDDF4CAE2BA8E` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dataark for tabell `t_user_roles`
--

INSERT INTO `t_user_roles` (`user_id`, `role_id`) VALUES
(61, 11),
(61, 13),
(61, 14),
(64, 14);

--
-- Begrensninger for dumpede tabeller
--

--
-- Begrensninger for tabell `t_user_roles`
--
ALTER TABLE `t_user_roles`
  ADD CONSTRAINT `FK309FDDF43C17FF19` FOREIGN KEY (`role_id`) REFERENCES `t_roles` (`role_id`),
  ADD CONSTRAINT `FK309FDDF4CAE2BA8E` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`);
