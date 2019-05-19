-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2019 at 08:13 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopping`
--

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `item_id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `sup_id` varchar(20) NOT NULL,
  `unit_price` float NOT NULL,
  `qty` int(11) NOT NULL,
  `description` text NOT NULL,
  `item_pic` text NOT NULL,
  `visibility` int(11) NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_id`, `name`, `sup_id`, `unit_price`, `qty`, `description`, `item_pic`, `visibility`, `created_at`) VALUES
(12, 'Atlas Book u', '11', 8001, 51, 'New Item u', '1', 11, '2019-05-01'),
(14, 'Pen Drive', '4', 800, 5, '8 gb', '', 0, '2019-05-10'),
(16, 'Sound Bar', '14', 233, 2, '13 max volume', 'https://media.wired.com/photos/5baeb8ced876900c69b091d9/191:100/pass/02-Vizio-Dolby-Atmos-Soundbar-SOURCE-Vizio-(1).jpg', 1, '2019-05-18');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `ord_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `cus_id` int(11) NOT NULL,
  `tot_qty` int(11) NOT NULL,
  `tot_price` float NOT NULL,
  `remark` varchar(100) NOT NULL,
  `delivery_status` int(1) NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`ord_id`, `item_id`, `cus_id`, `tot_qty`, `tot_price`, `remark`, `delivery_status`, `created_at`) VALUES
(2, 2, 3, 2, 30000, 'Safe delivery', 1, '2019-05-19');

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `rating_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `comment` varchar(30) NOT NULL,
  `cus_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `rate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`rating_id`, `item_id`, `comment`, `cus_id`, `date`, `rate`) VALUES
(2, 3, 'very good', 4, '2019-05-17', 5),
(3, 5, 'badd', 2, '2019-05-19', 1);

--
-- Indexes for dumped tables
--
CREATE TABLE `Suppliers` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `expertise` varchar(30) NOT NULL,
  `createdAt` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `Suppliers` (`id`,`name`,`designation`,`expertise`,`createdAt`) values
(5,'amal','Supplier','Art and Drawing','2019-05-20');

insert into `Suppliers` (`id`,`name`,`designation`,`expertise`,`createdAt`) values
(10,'perera','Supplier and Publisher','Science and Mathematics','2019-05-20');


--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`item_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ord_id`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`rating_id`);

--
-- AUTO_INCREMENT for dumped tables
--
ALTER TABLE `Suppliers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `ord_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
  
ALTER TABLE `Suppliers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;


--
-- AUTO_INCREMENT for table `rating`
--
ALTER TABLE `rating`
  MODIFY `rating_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
