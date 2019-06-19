-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 18-Jun-2019 às 00:28
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hiper_soft_database`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

CREATE TABLE `caixa` (
  `cx_cod` int(11) NOT NULL,
  `cod_usu` int(11) NOT NULL,
  `usu_cod` int(11) DEFAULT NULL,
  `cx_saldo_ini` decimal(10,2) DEFAULT NULL,
  `cx_saldo_fim` decimal(10,2) DEFAULT NULL,
  `cx_aber` date DEFAULT NULL,
  `cx_fecha` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `cod_cli` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`cod_cli`, `nome`, `endereco`, `cidade`) VALUES
(1, 'Laisla Mirele', 'Av.Cel. Marcondes  2700', 'Presidente Prudente'),
(3, 'Diego Elias Francisco', 'Rua Jose Ramos 250', 'Pirapozinho');

-- --------------------------------------------------------

--
-- Estrutura da tabela `compra`
--

CREATE TABLE `compra` (
  `cod_com` int(11) NOT NULL,
  `fornecedor_cod_for` int(11) NOT NULL,
  `tp_pag` varchar(40) DEFAULT NULL,
  `data_com` date DEFAULT NULL,
  `num_nota` int(11) DEFAULT NULL,
  `total_com` decimal(10,2) DEFAULT NULL,
  `parc_com` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `cod_for` int(11) NOT NULL,
  `nome_for` varchar(80) DEFAULT NULL,
  `cnpj_for` varchar(60) DEFAULT NULL,
  `end_for` varchar(60) DEFAULT NULL,
  `cidade_for` varchar(60) DEFAULT NULL,
  `estado_for` varchar(60) DEFAULT NULL,
  `tel_for` varchar(40) DEFAULT NULL,
  `email_for` varchar(60) DEFAULT NULL,
  `rz_social` varchar(80) DEFAULT NULL,
  `ie_for` varchar(40) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_compra`
--

CREATE TABLE `item_compra` (
  `cod_compra` int(11) NOT NULL,
  `cod_prod` int(11) NOT NULL,
  `compra_cod_com` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `valor` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens_venda`
--

CREATE TABLE `itens_venda` (
  `cod_item` int(11) NOT NULL,
  `cod_venda` int(11) NOT NULL,
  `cod_prod` int(11) NOT NULL,
  `qtd` int(11) NOT NULL,
  `valor` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `cod_prod` int(11) NOT NULL,
  `cod_uni_med` int(11) NOT NULL,
  `nome_prod` varchar(40) DEFAULT NULL,
  `setor_prod` varchar(60) DEFAULT NULL,
  `fabri_prod` varchar(60) DEFAULT NULL,
  `val_prod` varchar(60) DEFAULT NULL,
  `preco_prod` float(60,0) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`cod_prod`, `cod_uni_med`, `nome_prod`, `setor_prod`, `fabri_prod`, `val_prod`, `preco_prod`) VALUES
(18, 1, 'LEITE PARMALAT 1LT', 'LATICINIOS', '01/03/2019', '20/04/2019', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_pagamento`
--

CREATE TABLE `tipo_pagamento` (
  `cod_pag` int(11) NOT NULL,
  `cod_ven` int(11) NOT NULL,
  `tp_pag` varchar(40) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_produto`
--

CREATE TABLE `tipo_produto` (
  `id` int(11) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `unidade_medida`
--

CREATE TABLE `unidade_medida` (
  `cod_uni_med` int(11) NOT NULL,
  `uni_nome` varchar(80) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `usu_cod` int(11) NOT NULL,
  `usu_nome` varchar(60) DEFAULT NULL,
  `usu_senha` varchar(60) DEFAULT NULL,
  `usu_username` varchar(32) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`usu_cod`, `usu_nome`, `usu_senha`, `usu_username`) VALUES
(1, 'Diego Francisco', 'laisla96', 'deliasfrancisco'),
(2, 'Laisla Mirele', 'diego4615', 'milaisla');

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `venda_cod` int(11) NOT NULL,
  `caixa_cx_cod` int(11) NOT NULL,
  `cod_cli` int(11) NOT NULL,
  `ven_total` decimal(10,2) DEFAULT NULL,
  `data_ven` date DEFAULT NULL,
  `cx_cod` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `caixa`
--
ALTER TABLE `caixa`
  ADD PRIMARY KEY (`cx_cod`),
  ADD KEY `usu_cod` (`usu_cod`),
  ADD KEY `fk_caixa_usuario1_idx` (`cod_usu`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cod_cli`);

--
-- Indexes for table `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`cod_com`),
  ADD KEY `tp_pag` (`tp_pag`),
  ADD KEY `fk_compra_fornecedor1_idx` (`fornecedor_cod_for`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`cod_for`);

--
-- Indexes for table `item_compra`
--
ALTER TABLE `item_compra`
  ADD PRIMARY KEY (`cod_compra`),
  ADD KEY `fk_compra_has_produto_produto1_idx` (`cod_prod`),
  ADD KEY `fk_item_compra_compra1_idx` (`compra_cod_com`);

--
-- Indexes for table `itens_venda`
--
ALTER TABLE `itens_venda`
  ADD PRIMARY KEY (`cod_item`),
  ADD KEY `itens_cod` (`cod_item`),
  ADD KEY `fk_itens_venda_produto1_idx` (`cod_prod`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`cod_prod`),
  ADD KEY `fk_produto_unidade_medida1_idx` (`cod_uni_med`);

--
-- Indexes for table `tipo_pagamento`
--
ALTER TABLE `tipo_pagamento`
  ADD PRIMARY KEY (`cod_pag`),
  ADD KEY `fk_tipo_pagamento_venda1_idx` (`cod_ven`);

--
-- Indexes for table `tipo_produto`
--
ALTER TABLE `tipo_produto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `unidade_medida`
--
ALTER TABLE `unidade_medida`
  ADD PRIMARY KEY (`cod_uni_med`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usu_cod`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`venda_cod`),
  ADD KEY `cx_cod` (`cx_cod`),
  ADD KEY `fk_venda_caixa1_idx` (`caixa_cx_cod`),
  ADD KEY `fk_venda_cliente1_idx` (`cod_cli`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `cod_cli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `compra`
--
ALTER TABLE `compra`
  MODIFY `cod_com` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `cod_for` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `cod_prod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tipo_produto`
--
ALTER TABLE `tipo_produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usu_cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
