-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-09-2022 a las 15:18:19
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- ----------------------------------------------------------
-- Base de datos: `agenda`
--

CREATE DATABASE IF NOT EXISTS `agenda` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Me posiciono en la base recien creada para crear las tablas --
USE `agenda`
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deportes`
--

CREATE TABLE `deportes` (
  `idDeporte` int(11) NOT NULL,
  `nombreDeporte` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `deportes`
--

INSERT INTO `deportes` (`idDeporte`, `nombreDeporte`) VALUES
(1, 'FUTBOL'),
(2, 'TENIS'),
(3, 'NATACION');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domicilio`
--

CREATE TABLE `domicilio` (
  `idDomicilio` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `calle` varchar(200) NOT NULL,
  `altura` varchar(200) NOT NULL,
  `piso` varchar(200) NOT NULL,
  `depto` varchar(200) NOT NULL,
  `localidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `domicilio`
--

INSERT INTO `domicilio` (`idDomicilio`, `idPersona`, `calle`, `altura`, `piso`, `depto`, `localidad`) VALUES
(1, 11, 'JOSE C PAZ', '3841', '1', '2', 1),
(2, 9, 'SAN LUIS', '1095', '1', '8', 1),
(3, 5, 'SAN LUIS', '1541', '1', '5', 1),
(4, 4, 'SAN LUIS', '1095', '1', '8', 1),
(5, 3, 'Saporiti', '2315', '1', '6', 3),
(7, 2, 'SAN JOSE', '1095', '1', '8', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `idEquipo` int(11) NOT NULL,
  `nombreEquipo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`idEquipo`, `nombreEquipo`) VALUES
(1, 'SIN EQUIPO'),
(2, 'RIVER PLATE'),
(3, 'BOCA JUNIORS'),
(4, 'INDEPENDIENTE'),
(5, 'SAN LORENZO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidad`
--

CREATE TABLE `localidad` (
  `idlocalidad` int(11) NOT NULL,
  `nombrelocalidad` varchar(200) NOT NULL,
  `idprovincia` int(11) NOT NULL,
  `idpais` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `localidad`
--

INSERT INTO `localidad` (`idlocalidad`, `nombrelocalidad`, `idprovincia`, `idpais`) VALUES
(1, 'SAN MIGUEL', 1, 1),
(2, 'MALVINAS', 1, 1),
(3, 'HURLINGHAM', 1, 1),
(4, 'JOSE C PAZ', 1, 1),
(7, 'MORENO', 1, 1),
(8, 'VILLA BALLETER', 1, 1),
(10, 'CASTELAR', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `idpais` int(11) NOT NULL,
  `nombrepais` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`idpais`, `nombrepais`) VALUES
(1, 'ARGENTINA'),
(2, 'BRASIL'),
(3, 'CHILE'),
(4, 'PARAGUAY');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `idPersona` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `Cumpleaños` varchar(100) DEFAULT NULL,
  `idContacto` int(11) NOT NULL,
  `idDeporte` int(11) NOT NULL,
  `idEquipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`idPersona`, `Nombre`, `Telefono`, `email`, `Cumpleaños`, `idContacto`, `idDeporte`, `idEquipo`) VALUES
(2, 'Jose Luis Quiñones', '155562999', 'luis@gmail.com', '01/12/1971', 1, 1, 2),
(3, 'Enzo Arebalos', '1565323259', 'enzo@gmail.com', '18/8/1990', 1, 1, 3),
(4, 'Sabrina Jofre', '1568049999', 'sabrina@gmail.com', '12/12/1980', 1, 1, 3),
(5, 'Ivan Quiñones', '1159999999', 'ivan@gmail.com', '30/08/2010', 1, 3, 1),
(9, 'Walter Perez', '1565252565', 'walter@gmail.com', '12/12/1971', 3, 3, 1),
(11, 'Martin Rodrigues', '1563232565', 'martin@gmail.com', '21/09/1971', 3, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `idprovincia` int(11) NOT NULL,
  `nombreprovincia` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`idprovincia`, `nombreprovincia`) VALUES
(1, 'BUENOS AIRES'),
(2, 'CABA'),
(3, 'CATAMARCA'),
(4, 'CHACO'),
(5, 'CHUBUT'),
(6, 'CORDOBA'),
(7, 'CORRIENTES'),
(8, 'ENTRE RIOS'),
(9, 'FORMOSA'),
(10, 'JUJUY'),
(11, 'LA PAMPA'),
(12, 'LA RIOJA'),
(13, 'MENDOZA'),
(14, 'MISIONES'),
(15, 'NEUQUEN'),
(16, 'RIO NEGRO'),
(17, 'SALTA'),
(18, 'SAN JUAN'),
(19, 'SANTA CRUZ'),
(20, 'SANTA FE'),
(21, 'SANTIAGO DEL ESTERO'),
(22, 'TIERRA DEL FUEGO'),
(23, 'TUCUMAN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipocontacto`
--

CREATE TABLE `tipocontacto` (
  `idtipocontacto` int(11) NOT NULL,
  `nombretipo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipocontacto`
--

INSERT INTO `tipocontacto` (`idtipocontacto`, `nombretipo`) VALUES
(1, 'TRABAJO'),
(2, 'FAMILIA'),
(3, 'AMIGOS'),
(5, 'UNIVERSIDAD');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `deportes`
--
ALTER TABLE `deportes`
  ADD PRIMARY KEY (`idDeporte`);

--
-- Indices de la tabla `domicilio`
--
ALTER TABLE `domicilio`
  ADD PRIMARY KEY (`idDomicilio`);

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`idEquipo`);

--
-- Indices de la tabla `localidad`
--
ALTER TABLE `localidad`
  ADD PRIMARY KEY (`idlocalidad`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`idpais`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`idPersona`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`idprovincia`);

--
-- Indices de la tabla `tipocontacto`
--
ALTER TABLE `tipocontacto`
  ADD PRIMARY KEY (`idtipocontacto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `deportes`
--
ALTER TABLE `deportes`
  MODIFY `idDeporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `domicilio`
--
ALTER TABLE `domicilio`
  MODIFY `idDomicilio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `equipos`
--
ALTER TABLE `equipos`
  MODIFY `idEquipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `localidad`
--
ALTER TABLE `localidad`
  MODIFY `idlocalidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `idpais` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `provincia`
--
ALTER TABLE `provincia`
  MODIFY `idprovincia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `tipocontacto`
--
ALTER TABLE `tipocontacto`
  MODIFY `idtipocontacto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
