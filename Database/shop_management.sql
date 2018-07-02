-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2017 at 06:48 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `login_admin`
--

CREATE TABLE `login_admin` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_admin`
--

INSERT INTO `login_admin` (`id`, `username`, `password`, `role`) VALUES
(1, 'arif', '123', 'Admin'),
(2, 'admin', '123', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `login_employee`
--

CREATE TABLE `login_employee` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_employee`
--

INSERT INTO `login_employee` (`id`, `username`, `password`, `role`) VALUES
(1, 'emp', '123', 'Employee');

-- --------------------------------------------------------

--
-- Table structure for table `login_manager`
--

CREATE TABLE `login_manager` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_manager`
--

INSERT INTO `login_manager` (`id`, `username`, `password`, `role`) VALUES
(1, 'maneger', '123', 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Status` int(11) NOT NULL DEFAULT '0',
  `unit_id` int(11) NOT NULL,
  `Catagory_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `Name`, `Status`, `unit_id`, `Catagory_id`) VALUES
(2, 'Select', 1, 6, 5),
(3, 'Pencil', 1, 10, 6),
(5, 'Mouse', 1, 10, 7),
(6, 'Tel', 1, 10, 8),
(7, 'Other', 1, 7, 9),
(8, 'Rubber', 1, 10, 6),
(9, 'KeyBoard', 1, 10, 7),
(10, 'Water', 1, 8, 8),
(11, 'any', 1, 7, 9);

-- --------------------------------------------------------

--
-- Table structure for table `product_catagory`
--

CREATE TABLE `product_catagory` (
  `id` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Status` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_catagory`
--

INSERT INTO `product_catagory` (`id`, `Name`, `Status`) VALUES
(5, 'Select', 1),
(6, 'Stationary', 1),
(7, 'Electronics', 1),
(8, 'Liquid', 1),
(9, 'Raw', 1);

-- --------------------------------------------------------

--
-- Table structure for table `purchase_details`
--

CREATE TABLE `purchase_details` (
  `master_id` int(11) NOT NULL,
  `Product_id` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Buy_price` int(11) NOT NULL,
  `Total_Price` int(11) NOT NULL,
  `Sell_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_details`
--

INSERT INTO `purchase_details` (`master_id`, `Product_id`, `Quantity`, `Buy_price`, `Total_Price`, `Sell_price`) VALUES
(5, 8, 29, 42, 1218, 78),
(5, 9, 30, 4, 120, 80),
(5, 3, 36, 4444, 159984, 111111);

-- --------------------------------------------------------

--
-- Table structure for table `purchase_master`
--

CREATE TABLE `purchase_master` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `vendor_name` varchar(20) NOT NULL,
  `total_amount` int(11) NOT NULL,
  `pay` int(11) NOT NULL,
  `Due` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_master`
--

INSERT INTO `purchase_master` (`id`, `date`, `vendor_name`, `total_amount`, `pay`, `Due`, `status`) VALUES
(1, '2017-04-27', 'Arif', 44906, 40000, 4906, 1),
(2, '2017-04-27', 'Arif', 44906, 40000, 4906, 0),
(3, '2017-04-27', 'Arif', 44906, 44906, 0, 1),
(4, '2017-04-27', 'ajksdhfa', 283291, 200000, 83291, 0),
(5, '2017-04-30', 'qqqqqqqqqq', 161322, 161231, 91, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sale_details`
--

CREATE TABLE `sale_details` (
  `id` int(11) NOT NULL,
  `Product_id` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Buy_price` int(11) NOT NULL,
  `Total_Price` int(11) NOT NULL,
  `Sell_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sale_master`
--

CREATE TABLE `sale_master` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `vendor_name` varchar(20) NOT NULL,
  `total_amount` int(11) NOT NULL,
  `pay` int(11) NOT NULL,
  `Due` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `status` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id`, `name`, `status`) VALUES
(3, 'Select', 2),
(4, 'Enable', 1),
(5, 'Disable', 0);

-- --------------------------------------------------------

--
-- Table structure for table `temp`
--

CREATE TABLE `temp` (
  `id` int(11) NOT NULL,
  `Product_id` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Buy_price` int(11) NOT NULL,
  `Total_Price` int(11) NOT NULL,
  `Sell_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `temp`
--

INSERT INTO `temp` (`id`, `Product_id`, `Quantity`, `Buy_price`, `Total_Price`, `Sell_price`) VALUES
(1, 5, 10, 200, 2000, 250);

-- --------------------------------------------------------

--
-- Table structure for table `temp_sale`
--

CREATE TABLE `temp_sale` (
  `id` int(11) NOT NULL,
  `Product_id` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Buy_price` int(11) NOT NULL,
  `Total_Price` int(11) NOT NULL,
  `Sell_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

CREATE TABLE `unit` (
  `id` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Status` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unit`
--

INSERT INTO `unit` (`id`, `Name`, `Status`) VALUES
(6, 'Select', 1),
(7, 'KG', 1),
(8, 'Liter', 1),
(9, 'Miter', 1),
(10, 'Pices', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login_admin`
--
ALTER TABLE `login_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login_employee`
--
ALTER TABLE `login_employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login_manager`
--
ALTER TABLE `login_manager`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product_catagory`
--
ALTER TABLE `product_catagory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `purchase_master`
--
ALTER TABLE `purchase_master`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sale_details`
--
ALTER TABLE `sale_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sale_master`
--
ALTER TABLE `sale_master`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `temp`
--
ALTER TABLE `temp`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `temp_sale`
--
ALTER TABLE `temp_sale`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `unit`
--
ALTER TABLE `unit`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login_admin`
--
ALTER TABLE `login_admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `login_employee`
--
ALTER TABLE `login_employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `login_manager`
--
ALTER TABLE `login_manager`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `product_catagory`
--
ALTER TABLE `product_catagory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `purchase_master`
--
ALTER TABLE `purchase_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `sale_details`
--
ALTER TABLE `sale_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sale_master`
--
ALTER TABLE `sale_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `temp`
--
ALTER TABLE `temp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `temp_sale`
--
ALTER TABLE `temp_sale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `unit`
--
ALTER TABLE `unit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
