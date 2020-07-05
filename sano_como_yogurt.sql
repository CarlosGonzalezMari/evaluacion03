-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-07-2020 a las 23:53:00
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sano como yogurt`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaciones`
--

CREATE TABLE `asignaciones` (
  `asignacionesid` int(20) NOT NULL,
  `asignacion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asignaciones`
--

INSERT INTO `asignaciones` (`asignacionesid`, `asignacion`) VALUES
(2, 'Jueves Doce en punto PM'),
(4, 'Jueves Ocho en punto AM'),
(3, 'Jueves Tres y media PM'),
(1, 'Lunes Nueve y media PM'),
(6, 'Viernes Nueve en punto AM'),
(7, 'Viernes Ocho en punto PM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctores`
--

CREATE TABLE `doctores` (
  `doctoresId` int(50) NOT NULL,
  `doctores` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `doctores`
--

INSERT INTO `doctores` (`doctoresId`, `doctores`) VALUES
(2, 'Cristiano Ronaldo'),
(4, 'Jesus Padillas'),
(5, 'Juan Guarello'),
(3, 'Pedro PicaPiedras'),
(1, 'Pedro Suarez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidades`
--

CREATE TABLE `especialidades` (
  `especialidadId` int(50) NOT NULL,
  `tipoId` int(50) NOT NULL,
  `especialidad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialidades`
--

INSERT INTO `especialidades` (`especialidadId`, `tipoId`, `especialidad`) VALUES
(1, 1, 'Angiología'),
(2, 1, 'Dermatología'),
(3, 1, 'Ginecología y obstetricia o tocología'),
(4, 2, 'Oftalmología'),
(5, 2, 'Otorrinolaringología'),
(6, 2, 'Urología');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `requerimientos`
--

CREATE TABLE `requerimientos` (
  `requerimientoid` int(50) NOT NULL,
  `doctores` varchar(50) NOT NULL,
  `departamento` varchar(50) NOT NULL,
  `asignacion` varchar(50) NOT NULL,
  `encargado` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `requerimientos`
--

INSERT INTO `requerimientos` (`requerimientoid`, `doctores`, `departamento`, `asignacion`, `encargado`, `descripcion`, `estado`) VALUES
(1, '0', 'null', 'Lunes Nueve de la maÃ±ana', 'null', 'Carlos gonzalez: 20535367-4\r\nMe duele mucho la espalda', 'Abierto'),
(2, '0', 'null', 'Viernes Nueve en punto AM', 'null', 'Ignacio Vera: 20489678-7\r\nLos ojos los tengo rojo en la maÃ±ana y me cuesta ver', 'Abierto'),
(3, '0', 'null', 'Lunes Nueve y media PM', 'null', 'Juan Pacheco: 15785214-8 \r\nNecesito una cirugia vascular', 'Cerrado'),
(4, 'null', 'null', 'Jueves Doce en punto PM', 'null', '', 'Abierto'),
(5, 'null', 'null', 'Jueves Doce en punto PM', 'null', 'Carlos Gonzalez: 20535043-4 \r\nTengo dolores musculares hace varias semanas', 'Abierto'),
(6, 'null', 'null', 'Viernes Ocho en punto PM', 'null', 'a', 'Cerrado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuarioId` int(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuarioId`, `nombre`, `apellido`, `password`) VALUES
(1, 'carlos', 'gonzalez', 'hola');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  ADD PRIMARY KEY (`asignacionesid`),
  ADD KEY `asignacion` (`asignacion`);

--
-- Indices de la tabla `doctores`
--
ALTER TABLE `doctores`
  ADD PRIMARY KEY (`doctoresId`),
  ADD KEY `doctoresId` (`doctoresId`),
  ADD KEY `doctores` (`doctores`);

--
-- Indices de la tabla `especialidades`
--
ALTER TABLE `especialidades`
  ADD PRIMARY KEY (`especialidadId`),
  ADD KEY `especialidad` (`especialidad`);

--
-- Indices de la tabla `requerimientos`
--
ALTER TABLE `requerimientos`
  ADD PRIMARY KEY (`requerimientoid`),
  ADD KEY `doctores` (`doctores`),
  ADD KEY `doctores_2` (`doctores`),
  ADD KEY `asignacion` (`asignacion`),
  ADD KEY `doctores_3` (`doctores`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuarioId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
