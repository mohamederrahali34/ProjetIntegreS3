
-- --------------------------------------------------------

--
-- Structure de la table `chambres`
--

DROP TABLE IF EXISTS `chambres`;
CREATE TABLE IF NOT EXISTS `chambres` (
  `no_chambre` int(11) NOT NULL,
  `type_chambre` varchar(255) DEFAULT NULL,
  `nb_personnes` varchar(255) DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `cout` double(9,5) DEFAULT NULL,
  PRIMARY KEY (`no_chambre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
