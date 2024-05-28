-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-05-2024 a las 17:45:22
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `caja_ahorro`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
CREATE TABLE IF NOT EXISTS `cuenta` (
  `numero_cuenta` bigint NOT NULL AUTO_INCREMENT,
  `id_socio` bigint NOT NULL,
  `tasa_interes` float NOT NULL,
  `estatus_cuenta` int NOT NULL,
  `saldo` bigint NOT NULL,
  PRIMARY KEY (`numero_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `intereses`
--

DROP TABLE IF EXISTS `intereses`;
CREATE TABLE IF NOT EXISTS `intereses` (
  `id_interes` bigint NOT NULL AUTO_INCREMENT,
  `tasa_interes` double NOT NULL,
  `fecha_inicio` timestamp NOT NULL,
  `fecha_fin` timestamp NOT NULL,
  PRIMARY KEY (`id_interes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operacion`
--

DROP TABLE IF EXISTS `operacion`;
CREATE TABLE IF NOT EXISTS `operacion` (
  `id_operacion` bigint NOT NULL AUTO_INCREMENT,
  `numero_cuenta` bigint NOT NULL,
  `nombre` text NOT NULL,
  PRIMARY KEY (`id_operacion`),
  KEY `numero_cuenta_fk` (`numero_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

DROP TABLE IF EXISTS `pago`;
CREATE TABLE IF NOT EXISTS `pago` (
  `id_pago` bigint NOT NULL AUTO_INCREMENT,
  `id_prestamo` bigint NOT NULL,
  `cantidad` double NOT NULL,
  `fecha` timestamp NOT NULL,
  PRIMARY KEY (`id_pago`),
  KEY `id_prestamo_fk` (`id_prestamo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE IF NOT EXISTS `prestamo` (
  `id_prestamo` bigint NOT NULL AUTO_INCREMENT,
  `id_solicitud_prestamo` bigint NOT NULL,
  `id_intereses` bigint NOT NULL,
  `monto_prestado` double NOT NULL,
  `pago_actual` double NOT NULL,
  `fecha_solicitud` timestamp NOT NULL,
  `plazo` date NOT NULL,
  `num_montos` int NOT NULL,
  PRIMARY KEY (`id_prestamo`),
  KEY `id_solicitud_prestamo_fk` (`id_solicitud_prestamo`),
  KEY `id_intereses_fk` (`id_intereses`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` bigint NOT NULL AUTO_INCREMENT,
  `nombre` text NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socio`
--

DROP TABLE IF EXISTS `socio`;
CREATE TABLE IF NOT EXISTS `socio` (
  `id_socio` bigint NOT NULL AUTO_INCREMENT,
  `nombre` text NOT NULL,
  `apellidos` text NOT NULL,
  `direccion` text NOT NULL,
  `telefono` bigint NOT NULL,
  `correo` text NOT NULL,
  PRIMARY KEY (`id_socio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socio_cuenta`
--

DROP TABLE IF EXISTS `socio_cuenta`;
CREATE TABLE IF NOT EXISTS `socio_cuenta` (
  `id_socio_cuenta` bigint NOT NULL,
  `id_socio` bigint NOT NULL,
  `id_cuenta` bigint NOT NULL,
  PRIMARY KEY (`id_socio_cuenta`),
  KEY `id_socio_fk` (`id_socio`),
  KEY `id_cuenta_fk` (`id_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

DROP TABLE IF EXISTS `transaccion`;
CREATE TABLE IF NOT EXISTS `transaccion` (
  `id_transaccion` bigint NOT NULL AUTO_INCREMENT,
  `id_operacion` bigint NOT NULL,
  `monto` double NOT NULL,
  `fecha` timestamp NOT NULL,
  PRIMARY KEY (`id_transaccion`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `id_rol` bigint NOT NULL,
  `nombre` text NOT NULL,
  `correo` text NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_rol_fk` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`id_prestamo`) REFERENCES `prestamo` (`id_prestamo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`id_intereses`) REFERENCES `intereses` (`id_interes`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `socio_cuenta`
--
ALTER TABLE `socio_cuenta`
  ADD CONSTRAINT `socio_cuenta_ibfk_1` FOREIGN KEY (`id_socio`) REFERENCES `socio` (`id_socio`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `socio_cuenta_ibfk_2` FOREIGN KEY (`id_cuenta`) REFERENCES `cuenta` (`numero_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
