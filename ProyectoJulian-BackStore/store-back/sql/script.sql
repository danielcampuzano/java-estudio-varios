CREATE DATABASE `store` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8_spanish2_ci */;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `id_category` int(11) DEFAULT NULL,
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'A',
  PRIMARY KEY (`id`),
  KEY `fk_categories_id_category_idx` (`id_category`),
  CONSTRAINT `fk_category_references` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

CREATE TABLE `color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

CREATE TABLE `price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_reference` int(11) NOT NULL,
  `cost` decimal(12,2) NOT NULL,
  `discount_per` decimal(5,2) NOT NULL,
  `discount_cost` decimal(12,2) NOT NULL,
  `total_cost` decimal(12,2) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'A',
  PRIMARY KEY (`id`),
  KEY `price_reference_idx` (`id_reference`),
  CONSTRAINT `price_reference` FOREIGN KEY (`id_reference`) REFERENCES `reference` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ean` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `id_reference` int(11) NOT NULL,
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `id_color` int(11) NOT NULL,
  `id_size` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ean_UNIQUE` (`ean`),
  KEY `product_reference_idx` (`id_reference`),
  KEY `product_size_idx` (`id_size`),
  KEY `product_color_idx` (`id_color`),
  CONSTRAINT `product_color` FOREIGN KEY (`id_color`) REFERENCES `color` (`id`),
  CONSTRAINT `product_reference` FOREIGN KEY (`id_reference`) REFERENCES `reference` (`id`),
  CONSTRAINT `product_size` FOREIGN KEY (`id_size`) REFERENCES `size` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

CREATE TABLE `reference` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `id_category` int(11) NOT NULL,
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'A',
  `visible` varchar(1) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'I',
  `search_quanty` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_referency_category_idx` (`id_category`),
  CONSTRAINT `fk_referency_category` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

CREATE TABLE `size` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `description` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'A',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
