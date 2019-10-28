-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2019 a las 03:34:22
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `trabvivian`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentes`
--

CREATE TABLE `docentes` (
  `doc_id` int(11) NOT NULL,
  `doc_nombre` varchar(15) NOT NULL,
  `doc_password` varchar(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `doc_apellidos` varchar(20) NOT NULL,
  `doc_cod` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `docentes`
--

INSERT INTO `docentes` (`doc_id`, `doc_nombre`, `doc_password`, `timestamp`, `doc_apellidos`, `doc_cod`) VALUES
(1, 'strivino', '1213', '2019-10-17 01:14:00', 'calles', '13415'),
(7, 'AleossA', '12345', '2019-10-21 18:29:13', 'rodrigo', '999'),
(8, 'Vivian', 'Vorejuela', '2019-10-21 14:44:54', '2314', '123'),
(10, 'Jkad', '1256', '2019-10-21 15:15:29', 'jnm', '1923');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `res_id` int(11) NOT NULL,
  `res_hora_ini` time NOT NULL,
  `res_hora_fin` time NOT NULL,
  `res_id_sal` int(11) NOT NULL,
  `res_id_doc` int(11) NOT NULL,
  `res_fecha` date NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `token` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`res_id`, `res_hora_ini`, `res_hora_fin`, `res_id_sal`, `res_id_doc`, `res_fecha`, `timestamp`, `token`) VALUES
(84, '08:00:00', '09:00:00', 1, 1, '2019-10-24', '2019-10-22 19:52:37', 4777),
(101, '08:00:00', '09:00:00', 1, 1, '2019-10-23', '2019-10-22 20:33:27', 3220);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas`
--

CREATE TABLE `salas` (
  `sal_id` int(11) NOT NULL,
  `sal_num_equ` varchar(8) NOT NULL,
  `sal_ubicacion` varchar(15) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `sal_nombre` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `salas`
--

INSERT INTO `salas` (`sal_id`, `sal_num_equ`, `sal_ubicacion`, `timestamp`, `sal_nombre`) VALUES
(1, '12', 'Bloque A', '2019-10-23 02:26:03', 'Sala A'),
(4, '16', 'Bloque E', '2019-10-18 19:40:09', 'Sala V'),
(5, '8', 'Bloque M', '2019-10-19 21:38:59', 'Sala X');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `docentes`
--
ALTER TABLE `docentes`
  ADD PRIMARY KEY (`doc_id`),
  ADD UNIQUE KEY `doc_cod` (`doc_cod`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`res_id`),
  ADD KEY `sal_id` (`res_id_sal`),
  ADD KEY `doc_id` (`res_id_doc`);

--
-- Indices de la tabla `salas`
--
ALTER TABLE `salas`
  ADD PRIMARY KEY (`sal_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `docentes`
--
ALTER TABLE `docentes`
  MODIFY `doc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `res_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT de la tabla `salas`
--
ALTER TABLE `salas`
  MODIFY `sal_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`res_id_sal`) REFERENCES `salas` (`sal_id`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`res_id_doc`) REFERENCES `docentes` (`doc_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
