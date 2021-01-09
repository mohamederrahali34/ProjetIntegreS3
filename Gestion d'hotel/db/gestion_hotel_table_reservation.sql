
-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `No` int(11) NOT NULL,
  `CIN` int(11) NOT NULL,
  `date_reservation` date DEFAULT NULL,
  `nb_jours` int(11) DEFAULT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  PRIMARY KEY (`No`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
