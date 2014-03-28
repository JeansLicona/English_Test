-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-03-2014 a las 05:50:12
-- Versión del servidor: 5.6.14
-- Versión de PHP: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `english_test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluado`
--

CREATE TABLE IF NOT EXISTS `evaluado` (
  `id_evaluado` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) NOT NULL,
  `primer_apellido` varchar(50) NOT NULL,
  `segundo_apellido` varchar(50) NOT NULL,
  `nombre_usuario` varchar(45) NOT NULL,
  PRIMARY KEY (`id_evaluado`),
  UNIQUE KEY `id_evaluado_UNIQUE` (`id_evaluado`),
  UNIQUE KEY `nombre_usuario_UNIQUE` (`nombre_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

--
-- Volcado de datos para la tabla `evaluado`
--

INSERT INTO `evaluado` (`id_evaluado`, `nombres`, `primer_apellido`, `segundo_apellido`, `nombre_usuario`) VALUES
(35, 'Manuel Emeterio', 'Couoh', 'Flota', 'CFMa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE IF NOT EXISTS `pregunta` (
  `id_pregunta` int(11) NOT NULL AUTO_INCREMENT,
  `pregunta` varchar(110) COLLATE utf8_unicode_ci NOT NULL,
  `tipo_pregunta` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_pregunta`),
  UNIQUE KEY `id_pregunta_UNIQUE` (`id_pregunta`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`id_pregunta`, `pregunta`, `tipo_pregunta`) VALUES
(1, 'How should you address this young couple?', '0'),
(2, 'The act of registering at a hotel is:', '0'),
(3, 'Paul and Linda´s room is on the third floor. They don´t want to walk, so they’ll use', '0'),
(4, 'If the hotel is overbooked, what should you say to a guest that wants a room?\r\nI’m sorry, …', '0'),
(5, 'After having lunch at the restaurant, they should ask for', '0'),
(6, 'Complete the menu by dragging the words from the box to the correct place.', '1'),
(7, 'Complete the chart by dragging the words from the box to the correct place.', '1'),
(8, 'Match the words in column A with their picture in column B. Write the number in the parenthesis.', '2'),
(9, 'Match the words in column A with their definitions in column B. Write the number in the parenthesis.', '2'),
(10, 'Match the word  in column A with the picture in column B. Write the number in the ', '2'),
(11, 'Match the product (column A) with the place where you can buy it (column B) by writing the correct number in t', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE IF NOT EXISTS `respuesta` (
  `id_respuesta` int(11) NOT NULL AUTO_INCREMENT,
  `respuesta` varchar(45) CHARACTER SET latin1 NOT NULL,
  `ponderacion` double NOT NULL,
  `pregunta_id` int(11) NOT NULL,
  PRIMARY KEY (`id_respuesta`),
  KEY `fk_pregunta_respuesta_idx` (`pregunta_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=94 ;

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`id_respuesta`, `respuesta`, `ponderacion`, `pregunta_id`) VALUES
(1, 'Mr. and Mrs. Smith', 1, 1),
(2, 'Sir and Madam Smith', 0, 1),
(3, 'Lady and gentleman Smith', 0, 1),
(4, 'Miss and Mr. Smith', 0, 1),
(5, 'Check out', 0, 2),
(6, 'Check in', 1, 2),
(7, 'Check over', 0, 2),
(8, 'Check on', 0, 2),
(9, 'the corridor', 0, 3),
(10, 'the car', 0, 3),
(11, 'the stairway', 0, 3),
(12, 'the elevator', 1, 3),
(13, 'we don’t have any vacancies.', 1, 4),
(14, 'there are available rooms.', 0, 4),
(15, 'we only have one vacancy room.', 0, 4),
(16, 'come back soon.', 0, 4),
(17, 'the menu', 1, 5),
(18, 'the bill', 0, 5),
(19, 'the tip', 0, 5),
(20, 'the order', 0, 5),
(21, 'Starters', 0, 6),
(22, 'vegetable soup', 0, 6),
(23, 'green salad', 0, 6),
(24, 'beef steak', 0, 6),
(25, 'Main courses', 0, 6),
(26, 'grilled sardines', 0, 6),
(27, 'roast chicken', 0, 6),
(28, 'baked salmon', 0, 6),
(29, 'Desserts', 0, 6),
(30, 'Chocolate cake', 0, 6),
(31, 'ice cream', 0, 6),
(32, 'aple pie', 0, 6),
(33, 'Drinks', 0, 6),
(34, 'red wine', 0, 6),
(35, 'orange juice', 0, 6),
(36, 'mineral water', 0, 6),
(37, 'Room', 0, 7),
(38, 'double bed', 0, 7),
(39, 'radio alarm', 0, 7),
(40, 'chaise launge', 0, 7),
(41, 'Bathroom', 0, 7),
(42, 'toilet paper', 0, 7),
(43, 'soap dish', 0, 7),
(44, 'dining char', 0, 7),
(45, 'Restaurant', 0, 7),
(46, 'tea cart', 0, 7),
(47, 'pillow case', 0, 7),
(48, 'water slide', 0, 7),
(49, 'Pool Area', 0, 7),
(50, 'life guard', 0, 7),
(51, 'show cutain', 0, 7),
(52, 'salt shaker', 0, 7),
(53, 'Tent', 0, 8),
(54, 'Tent.png', 0, 8),
(55, 'Passport', 0, 8),
(56, 'Passport.png', 0, 8),
(57, 'Suitcase', 0, 8),
(58, 'Suitcase.png', 0, 8),
(59, 'ATM', 0, 8),
(60, 'ATM.png', 0, 8),
(61, 'Luggage', 0, 8),
(62, 'Luggage.png', 0, 8),
(63, 'museum', 0, 9),
(64, 'a place where historical items are displayed.', 0, 9),
(65, 'market', 0, 9),
(66, 'a place to buy fresh food and homemade items.', 0, 9),
(67, 'monument', 0, 9),
(68, 'a statue or structure that reminds an event o', 0, 9),
(69, 'gallery', 0, 9),
(70, 'a building for the exhibition of artistic wor', 0, 9),
(71, 'church', 0, 9),
(72, 'a building for public Christian worship', 0, 9),
(74, 'travel brochure', 0, 10),
(75, 'travel_brochure.png', 0, 10),
(76, 'straw hat', 0, 10),
(77, 'straw_hat.png', 0, 10),
(78, 'straw hat', 0, 10),
(79, 'straw_hat.png', 0, 10),
(80, 'hiking shoes', 0, 10),
(81, 'hiking_shoes', 0, 10),
(82, 'bug spray', 0, 10),
(83, 'bug_spray', 0, 10),
(84, 'a fishing rod', 0, 11),
(85, 'Corner shop', 0, 11),
(86, 'a pocket dictionary', 0, 11),
(87, 'Book shop', 0, 11),
(88, 'a diet soda', 0, 11),
(89, 'Sport shop', 0, 11),
(90, 'a old clock', 0, 11),
(91, 'Antique shop', 0, 11),
(92, 'a cotton blouse', 0, 11),
(93, 'Clothing shop', 0, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultado`
--

CREATE TABLE IF NOT EXISTS `resultado` (
  `id_resultado` int(11) NOT NULL AUTO_INCREMENT,
  `evaluado` int(11) NOT NULL,
  `calificacion` double NOT NULL,
  PRIMARY KEY (`id_resultado`),
  KEY `fk_calificacion_evaluado_idx` (`evaluado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `fk_pregunta_respuesta` FOREIGN KEY (`pregunta_id`) REFERENCES `pregunta` (`id_pregunta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `resultado`
--
ALTER TABLE `resultado`
  ADD CONSTRAINT `fk_calificacion_evaluado` FOREIGN KEY (`evaluado`) REFERENCES `evaluado` (`id_evaluado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;