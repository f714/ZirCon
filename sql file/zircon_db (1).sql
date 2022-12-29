-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2022 at 09:15 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zircon_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `FullName` varchar(100) DEFAULT NULL,
  `AdminEmail` varchar(120) DEFAULT NULL,
  `UserName` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `updationDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `FullName`, `AdminEmail`, `UserName`, `Password`, `updationDate`) VALUES
(7, 'Admin 2 - updated', 'admin2@gmail.com', 'admin2', '123456', '2022-07-26 22:24:22'),
(8, 'anza', 'anza@gmail.com', 'anza', '121212', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `app_users`
--

CREATE TABLE `app_users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `app_users`
--

INSERT INTO `app_users` (`id`, `name`, `email`, `password`, `created_date`, `updated_date`) VALUES
(1, '', '', '202cb962ac59075b964b07152d234b70', '2022-11-10 18:03:41', NULL),
(2, '', '', '827ccb0eea8a706c4c34a16891f84e7b', '2022-11-10 18:05:02', NULL),
(3, '', '', '202cb962ac59075b964b07152d234b70', '2022-11-10 18:07:20', NULL),
(4, '', '', '202cb962ac59075b964b07152d234b70', '2022-11-10 18:10:41', NULL),
(5, '', '', '6f04f0d75f6870858bae14ac0b6d9f73', '2022-11-10 18:13:02', NULL),
(6, 'Anza Zafar', 'anzazafar2001@gmail.com', '47506db3706c8c0a2debf87eef140d36', '2022-11-10 18:26:17', NULL),
(7, 'Anza Zafar', 'anzazafar2001@gmail.com', '47506db3706c8c0a2debf87eef140d36', '2022-11-10 18:28:41', NULL),
(8, 'wania irfan', 'waniairfan888@gmail.com', 'fd548854e1678782649e302b22ac4bf2', '2022-11-10 18:53:18', NULL),
(9, 'alina ahmed', 'alina@gmail.com', 'f0c4c3fd06e3cc761cf732f1ce90837e', '2022-11-10 19:43:27', NULL),
(10, 'wania Arslan', 'wania@gmail.com', 'b390bfae0311b185e27c442b15170242', '2022-11-13 20:26:22', NULL),
(11, 'anza zafar', 'anzazafar@gmail.com', '47506db3706c8c0a2debf87eef140d36', '2022-11-15 09:41:51', NULL),
(12, 'anzafasih', 'anzafasih@gmail.com', '1f6d22837400f30a120d776244a5aaa3', '2022-11-26 19:34:30', NULL),
(13, '', 'fshzafar@gmail.com', '3b712de48137572f3849aabd5666a4e3', '2022-11-26 20:16:43', NULL),
(14, 'Anza', 'anza@gmail.com', '202cb962ac59075b964b07152d234b70', '2022-11-26 20:21:31', NULL),
(15, 'anzazafar', 'anzazafar2001@gmail.com', '1f6d22837400f30a120d776244a5aaa3', '2022-11-29 23:24:32', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `community_rooms`
--

CREATE TABLE `community_rooms` (
  `id` int(11) NOT NULL,
  `owner_id` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `start_date` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `pr_type` varchar(255) DEFAULT NULL,
  `number_of_participants` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `recitation_target` varchar(255) DEFAULT '0',
  `recitation_completed` varchar(255) DEFAULT '0',
  `status` varchar(255) DEFAULT NULL,
  `zikr_title` varchar(255) DEFAULT NULL,
  `zikr_description` longtext DEFAULT NULL,
  `zikr_narrator` varchar(255) DEFAULT NULL,
  `zikr_language` varchar(255) DEFAULT NULL,
  `zikr_number_of_ayat` varchar(255) DEFAULT NULL,
  `zikr_counting` varchar(255) DEFAULT NULL,
  `zikr_notification_status` varchar(255) DEFAULT '0',
  `created_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `community_rooms`
--

INSERT INTO `community_rooms` (`id`, `owner_id`, `title`, `description`, `start_date`, `start_time`, `end_date`, `end_time`, `pr_type`, `number_of_participants`, `duration`, `recitation_target`, `recitation_completed`, `status`, `zikr_title`, `zikr_description`, `zikr_narrator`, `zikr_language`, `zikr_number_of_ayat`, `zikr_counting`, `zikr_notification_status`, `created_date`) VALUES
(1, '1', 'community room 1', 'recite Ayat-e-Kareema', '2022-11-26 13:49:55', '2022-11-26 13:49:55', '2022-11-30 17:49:55', '2022-11-30 17:49:55', 'Collective', '15', '7', '10000', '0', 'In-Progress', '123', 'recite ayat-e-kareema ', 'narrator 1', 'Arabic', '1', '10000', '0', '2022-11-26 13:49:55'),
(2, '15', 'ayat 1', '100 times1', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'community', '2', '20', 'Recitation Target', '0', 'Not Started', NULL, NULL, NULL, NULL, NULL, NULL, '0', '2022-12-02 01:14:42'),
(3, '15', 'quran', '30 ', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'community', '3', '35', '300', '0', 'In Progress', NULL, NULL, NULL, NULL, NULL, NULL, '0', '2022-12-02 01:56:37');

-- --------------------------------------------------------

--
-- Table structure for table `diseases`
--

CREATE TABLE `diseases` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` longtext DEFAULT NULL,
  `verse` longtext NOT NULL,
  `translation` longtext NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diseases`
--

INSERT INTO `diseases` (`id`, `title`, `description`, `verse`, `translation`, `created_date`, `updated_date`) VALUES
(1, 'For increase in education updated', '                                                           It is the favourite prayer of Prophet Muhammad (PBUH)                                                    ', 'وَقُل رَّبِّ زِدْنِي عِلْمًا                                                    ', 'My Lord, increase me in knowledge                                                    ', '2022-12-03 03:46:25', '2022-12-03 04:00:39');

-- --------------------------------------------------------

--
-- Table structure for table `individual_rooms`
--

CREATE TABLE `individual_rooms` (
  `id` int(11) NOT NULL,
  `owner_id` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `start_date` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `pr_type` varchar(255) DEFAULT NULL,
  `number_of_participants` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `recitation_target` varchar(255) DEFAULT '0',
  `recitation_completed` varchar(255) DEFAULT '0',
  `status` varchar(255) DEFAULT NULL,
  `created_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `individual_rooms`
--

INSERT INTO `individual_rooms` (`id`, `owner_id`, `title`, `description`, `start_date`, `start_time`, `end_date`, `end_time`, `pr_type`, `number_of_participants`, `duration`, `recitation_target`, `recitation_completed`, `status`, `created_date`) VALUES
(1, '1', 'personal_room 1', 'pr1 desc', '2022-11-22 00:00:00', '0000-00-00 00:00:00', '2022-12-21 00:00:00', '0000-00-00 00:00:00', 'personal', '1', '20', '0', '0', 'In-Progress', '2022-11-21 22:50:59'),
(8, '15', 'ayat', '100 times', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'individual', '1', '20', '100', '0', 'in progress', '2022-12-01 01:55:03'),
(9, '15', 'ayat', '100 times', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'individual', '1', '20', '100', '0', 'in progress', '2022-12-01 23:56:40'),
(10, '', 'ayat', '100 times', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'individual', '1', '20', '100', '0', '', '2022-12-02 00:24:16'),
(11, '', 'ayat', '100 times', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'individual', '1', '20', '100', '0', 'Not Started', '2022-12-02 00:25:19'),
(12, '15', 'test', '123', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Individual', '123', '123', 'Recitation Target', '0', 'Not Started', '2022-12-02 00:56:13'),
(13, '15', 'test', '123', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Individual', '123', '123', 'Recitation Target', '0', 'Not Started', '2022-12-02 00:56:28'),
(14, '15', 'quran', '20 times', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Individual', '1', '2', 'R20', '0', 'In Progress', '2022-12-02 01:02:10'),
(15, '15', 'ayat ', '100 times ', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Individual', '1', '23', '100', '0', 'In Progress', '2022-12-02 01:54:43'),
(16, '15', 'ayat', '100 times', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Individual', '1', '20', '100', '0', 'In Progress', '2022-12-02 10:09:42'),
(17, '15', 'ayat', '100 times', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Individual', '1', '20', '100', '0', 'In Progress', '2022-12-02 10:43:47'),
(18, '15', '', '', '2012-02-22 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Individual', '', '11', 'Recitation Target', '0', 'Not Started', '2022-12-02 21:18:29');

-- --------------------------------------------------------

--
-- Table structure for table `inspirations`
--

CREATE TABLE `inspirations` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `image` longtext NOT NULL,
  `updated_date` datetime DEFAULT NULL,
  `created_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inspirations`
--

INSERT INTO `inspirations` (`id`, `title`, `image`, `updated_date`, `created_date`) VALUES
(1, 'Stay away from Haram uu', '20221202113238Screenshot (3).png', '2022-12-03 12:47:58', '2022-12-03 02:44:41');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(55) DEFAULT NULL,
  `username` varchar(55) DEFAULT NULL,
  `email` varchar(55) DEFAULT NULL,
  `password` varchar(55) DEFAULT NULL,
  `phone` varchar(55) DEFAULT NULL,
  `reg_date` datetime DEFAULT current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `email`, `password`, `phone`, `reg_date`) VALUES
(1, 'admin', 'admin', 'admin@gmail.comm', '1234', '0900786101', '2022-12-03 02:22:47');

-- --------------------------------------------------------

--
-- Table structure for table `verses`
--

CREATE TABLE `verses` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` longtext NOT NULL,
  `verse` longtext NOT NULL,
  `translation` longtext NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `verses`
--

INSERT INTO `verses` (`id`, `title`, `description`, `verse`, `translation`, `created_date`, `updated_date`) VALUES
(1, 'For increase in education', 'hadith of the day', 'وَقُل رَّبِّ زِدْنِي عِلْمًا', 'My Lord, increase me in knowledge', '2022-12-03 04:11:14', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `app_users`
--
ALTER TABLE `app_users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `community_rooms`
--
ALTER TABLE `community_rooms`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `diseases`
--
ALTER TABLE `diseases`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `individual_rooms`
--
ALTER TABLE `individual_rooms`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inspirations`
--
ALTER TABLE `inspirations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `verses`
--
ALTER TABLE `verses`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `app_users`
--
ALTER TABLE `app_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `community_rooms`
--
ALTER TABLE `community_rooms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `diseases`
--
ALTER TABLE `diseases`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `individual_rooms`
--
ALTER TABLE `individual_rooms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `inspirations`
--
ALTER TABLE `inspirations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `verses`
--
ALTER TABLE `verses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
