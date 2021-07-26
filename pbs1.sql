-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Jun 2021 pada 16.12
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbs1`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(255) NOT NULL,
  `nama_barang` varchar(255) NOT NULL,
  `harga` int(11) NOT NULL,
  `id_supplier` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `harga`, `id_supplier`) VALUES
('H15151', 'Tween 20, 500ml', 2551000, 'SPL0004'),
('P1197', 'Nuclease-Free Water, 500ml', 2668000, 'SPL0004');

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `id_customer` varchar(255) NOT NULL,
  `nama_customer` varchar(255) NOT NULL,
  `alamat_customer` text NOT NULL,
  `no_telp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`id_customer`, `nama_customer`, `alamat_customer`, `no_telp`) VALUES
('PLG0001', 'Lazuardi Fadhilah', 'Otista Cawang 1 RT 05 RW 12 No 18A', '081584924335'),
('PLG0002', 'Fidelia Rahayu Kusuma', 'Bekasi Timur', '08158459456');

-- --------------------------------------------------------

--
-- Struktur dari tabel `details`
--

CREATE TABLE `details` (
  `id_detail` varchar(255) NOT NULL,
  `no_order` varchar(255) NOT NULL,
  `id_supplier` varchar(255) NOT NULL,
  `id_barang` varchar(255) NOT NULL,
  `qty` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `details`
--

INSERT INTO `details` (`id_detail`, `no_order`, `id_supplier`, `id_barang`, `qty`, `total_harga`) VALUES
('DTL0001', 'INV0001', 'SPL0004', 'H15151', 1, 2551000),
('DTL0002', 'INV0001', 'SPL0004', 'P1197', 1, 2668000),
('DTL0003', 'INV0001', 'SPL0004', 'H15151', 1, 2551000),
('DTL0004', 'INV0002', 'SPL0004', 'H15151', 1, 2551000),
('DTL0005', 'INV0002', 'SPL0004', 'P1197', 5, 13340000),
('DTL0006', 'INV0002', 'SPL0004', 'P1197', 2, 5336000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `gudang`
--

CREATE TABLE `gudang` (
  `id_gudang` varchar(255) NOT NULL,
  `id_barang` varchar(255) NOT NULL,
  `no_order` varchar(255) NOT NULL,
  `qty` int(11) NOT NULL,
  `tgl_expired` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `gudang`
--

INSERT INTO `gudang` (`id_gudang`, `id_barang`, `no_order`, `qty`, `tgl_expired`) VALUES
('GD0001', 'H15151', 'INV0001', 3, '2021-06-24'),
('GD0002', 'P1197', 'INV0001', 2, '2021-06-26');

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` varchar(255) NOT NULL,
  `nama_karyawan` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  `jabatan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama_karyawan`, `username`, `password`, `jabatan`) VALUES
('KRW0001', 'Lazuardi Fadhilah', 'Lazuardi', 'Lazuardi', 'Sales'),
('KRW0002', 'Fidelia Rahayu Kusuma', 'Fidelia', 'Fidel', 'Admin'),
('KRW0003', 'Lazuardi', 'Ardi', 'Ardi', 'Purchasing');

-- --------------------------------------------------------

--
-- Struktur dari tabel `orders`
--

CREATE TABLE `orders` (
  `no_order` varchar(255) NOT NULL,
  `id_customer` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `orders`
--

INSERT INTO `orders` (`no_order`, `id_customer`) VALUES
('INV0001', 'PLG0001'),
('INV0002', 'PLG0002');

-- --------------------------------------------------------

--
-- Struktur dari tabel `reimbursement`
--

CREATE TABLE `reimbursement` (
  `id_reimburse` varchar(255) NOT NULL,
  `id_karyawan` varchar(255) NOT NULL,
  `kegiatan` text NOT NULL,
  `biaya` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `reimbursement`
--

INSERT INTO `reimbursement` (`id_reimburse`, `id_karyawan`, `kegiatan`, `biaya`) VALUES
('RMB0001', 'KRW0003', 'Antar reagent ke PT Prodia Widyahusada Tbk	', 50000),
('RMB0002', 'KRW0003', 'Bensin kirim reagent ke Prodia', 150000),
('RMB0003', 'KRW0001', 'Antar Berkas Ke Prodia\n', 50000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` varchar(255) NOT NULL,
  `nama_supplier` varchar(255) NOT NULL,
  `alamat_supplier` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `nama_supplier`, `alamat_supplier`) VALUES
('SPL0001', 'Lazuardi Fadhilah', 'Otista Cawang 1 RT 05 RW 12 No 18 A'),
('SPL0002', 'Neneng Herliana', 'Otitsta Cawang'),
('SPL0003', 'PT Nutrilab Pratama', 'Jl. Raya Kebayoran Lama No. 18 Jakarta 12210'),
('SPL0004', 'PT Indolab Utama', 'Mutiara Taman Palem Blok E3 No.9 Cengkareng Jakarta Barat 11730');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Indeks untuk tabel `details`
--
ALTER TABLE `details`
  ADD PRIMARY KEY (`id_detail`);

--
-- Indeks untuk tabel `gudang`
--
ALTER TABLE `gudang`
  ADD PRIMARY KEY (`id_gudang`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indeks untuk tabel `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`no_order`);

--
-- Indeks untuk tabel `reimbursement`
--
ALTER TABLE `reimbursement`
  ADD PRIMARY KEY (`id_reimburse`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
