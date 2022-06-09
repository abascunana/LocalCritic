-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Jun 08, 2022 at 02:04 PM
-- Server version: 8.0.29
-- PHP Version: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `LocalCritic`
--

-- --------------------------------------------------------

--
-- Table structure for table `canciones`
--

CREATE TABLE `canciones` (
  `cancionID` int NOT NULL,
  `tituloCancion` varchar(100) NOT NULL,
  `artista` varchar(100) DEFAULT NULL,
  `generoCancion` varchar(100) DEFAULT NULL,
  `anoLanzamientoCancion` int DEFAULT NULL,
  `duracionCancion` varchar(100) DEFAULT NULL,
  `productoraCancion` varchar(100) DEFAULT NULL,
  `portadaCancion` mediumblob,
  `mediaValCancion` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `libros`
--

CREATE TABLE `libros` (
  `ISBN` int NOT NULL,
  `tituloLibro` varchar(100) NOT NULL,
  `sinopsisLibro` varchar(500) DEFAULT NULL,
  `generoLibro` varchar(100) DEFAULT NULL,
  `escritor` varchar(100) DEFAULT NULL,
  `editorial` varchar(100) DEFAULT NULL,
  `anoLanzamientoLibro` int DEFAULT NULL,
  `numPag` varchar(100) DEFAULT NULL,
  `ultimaEdicion` varchar(100) DEFAULT NULL,
  `portadaLibro` mediumblob,
  `mediaValLibro` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `obras`
--

CREATE TABLE `obras` (
  `obraID` int NOT NULL,
  `tituloObra` varchar(100) NOT NULL,
  `tipoObra` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `peliculas`
--

CREATE TABLE `peliculas` (
  `peliculaID` int NOT NULL,
  `tituloPelicula` varchar(100) NOT NULL,
  `sinopsisPelicula` varchar(500) DEFAULT NULL,
  `generoPelicula` varchar(100) DEFAULT NULL,
  `actor` varchar(100) DEFAULT NULL,
  `anoLanzamientoPelicula` int DEFAULT NULL,
  `duracionPelicula` varchar(100) DEFAULT NULL,
  `director` varchar(100) DEFAULT NULL,
  `productoraPelicula` varchar(100) DEFAULT NULL,
  `portadaPelicula` mediumblob,
  `mediaValPelicula` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `usuarioID` int NOT NULL,
  `nombreUsuario` varchar(100) DEFAULT NULL,
  `tipoUsuario` varchar(100) DEFAULT NULL,
  `emailUsuario` varchar(100) DEFAULT NULL,
  `medioPrensa` varchar(100) DEFAULT NULL,
  `contraseñaUsuario` varchar(100) DEFAULT NULL,
  `fotoUsuario` mediumblob,
  `karma` int DEFAULT NULL,
  `reviewNum` int DEFAULT NULL,
  `mediaValUsuario` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `videojuegos`
--

CREATE TABLE `videojuegos` (
  `juegoID` int NOT NULL,
  `tituloJuego` varchar(100) NOT NULL,
  `descripcionJuego` varchar(500) DEFAULT NULL,
  `generoJuego` varchar(100) DEFAULT NULL,
  `plataformaJuego` varchar(100) DEFAULT NULL,
  `anoLanzamientoJuego` int DEFAULT NULL,
  `desarrolladoraJuego` varchar(100) DEFAULT NULL,
  `distribuidoraJuego` varchar(100) DEFAULT NULL,
  `portadaJuego` mediumblob,
  `mediaValJuego` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `canciones`
--
ALTER TABLE `canciones`
  ADD PRIMARY KEY (`cancionID`,`tituloCancion`);

--
-- Indexes for table `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`ISBN`,`tituloLibro`);

--
-- Indexes for table `obras`
--
ALTER TABLE `obras`
  ADD PRIMARY KEY (`obraID`,`tituloObra`);

--
-- Indexes for table `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`peliculaID`,`tituloPelicula`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuarioID`);

--
-- Indexes for table `videojuegos`
--
ALTER TABLE `videojuegos`
  ADD PRIMARY KEY (`juegoID`,`tituloJuego`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `canciones`
--
ALTER TABLE `canciones`
  MODIFY `cancionID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `peliculaID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `usuarioID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `videojuegos`
--
ALTER TABLE `videojuegos`
  MODIFY `juegoID` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
