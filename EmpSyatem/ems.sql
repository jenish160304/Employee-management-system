-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 07, 2023 at 06:50 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ems`
--

-- --------------------------------------------------------

--
-- Table structure for table `addemp`
--

CREATE TABLE `addemp` (
  `Name` varchar(30) DEFAULT NULL,
  `Fathername` varchar(30) DEFAULT NULL,
  `Surname` varchar(30) DEFAULT NULL,
  `Emial` varchar(30) DEFAULT NULL,
  `Designation` varchar(30) DEFAULT NULL,
  `EmployeeId` varchar(10) DEFAULT NULL,
  `Birthdate` varchar(10) DEFAULT NULL,
  `Salary` varchar(8) DEFAULT NULL,
  `Phoneno` varchar(30) DEFAULT NULL,
  `Education` varchar(10) DEFAULT NULL,
  `Adharcaredno` varchar(14) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `addemp`
--

INSERT INTO `addemp` (`Name`, `Fathername`, `Surname`, `Emial`, `Designation`, `EmployeeId`, `Birthdate`, `Salary`, `Phoneno`, `Education`, `Adharcaredno`, `Address`) VALUES
('raj', 'rajabhai', 'sheth', 'raj@gmail.com', 'had of branch', '45173', '16/5/2021', '12000', '7492449422', 'MA', '552211', 'delhi'),
('a', 'a', 'a', 'a@gmail.com', 'aa', '31833', '12/1/2014', '12000', '7433924494', 'B.COM', '123456789', 'a'),
('abhishek', 'dipakbhai', 'purohit', 'abhi@gamil.com', 'prompt eng', '18206', '18/08/2003', '15000', '7586094251', 'BBA', '1453698720', 'bhutnath'),
('jenuu', 'jeni', 'vag', 'j@gmial.com', 'sdnx', '68670', '12-12-2012', '15000', '74984465', 'BTech', '141245478', 'kmxkmxs');

--
-- Triggers `addemp`
--
DELIMITER $$
CREATE TRIGGER `safe` AFTER DELETE ON `addemp` FOR EACH ROW INSERT INTO backup(Name) VALUES(OLD.Name)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `backup`
--

CREATE TABLE `backup` (
  `Name` varchar(30) DEFAULT NULL,
  `Fathername` varchar(30) DEFAULT NULL,
  `Surname` varchar(30) DEFAULT NULL,
  `Emial` varchar(30) DEFAULT NULL,
  `Designation` varchar(30) DEFAULT NULL,
  `EmployeeId` varchar(10) DEFAULT NULL,
  `Birthdate` varchar(10) DEFAULT NULL,
  `Salary` varchar(8) DEFAULT NULL,
  `Phoneno` varchar(30) DEFAULT NULL,
  `Education` varchar(10) DEFAULT NULL,
  `Adharcaredno` varchar(14) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `backup`
--

INSERT INTO `backup` (`Name`, `Fathername`, `Surname`, `Emial`, `Designation`, `EmployeeId`, `Birthdate`, `Salary`, `Phoneno`, `Education`, `Adharcaredno`, `Address`) VALUES
('raj', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sign`
--

CREATE TABLE `sign` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sign`
--

INSERT INTO `sign` (`username`, `password`, `Email`) VALUES
('', '', ''),
('aaaa', 'bbbb', 'cccc'),
('jenuu', 'patel', 'jenu@gmail.com'),
('jenish', 'jeuu', 'a@gmail.com'),
('jenish', 'jenuu', 'jenu@gmail.com'),
('aaa', 'aaabbb', 'aaa@gmail.com'),
('aaaaa', 'abcd', 'aa@gmail.com'),
('abhishek', 'mahadev', 'abhi@gamil.com'),
('JEEL', 'jilu', 'j@gamil.com'),
('karan', 'karan918', 'karan@gmail.com'),
('vivek', '123456', 'vivek@gmail.com');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
