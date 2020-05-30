INSERT INTO `utilisateur` (`id`, `email`, `nom`, `password`, `prenom`, `role`) VALUES
(1, 'admin@ae.fr', 'Administrateur', '$2a$10$Ed5C6Fu.cQJEp4FG6GjjAOSzE6a/NJ1UFJxHBz6X3QURDMassvGyW', '', 'ROLE_ADMINISTRATEUR'),
(2, 'member@ae.fr', 'Membre', '$2a$10$7H9uCf6UdgiDT1z05rnvOe/iqkA4ZxzAzmVUy5BgQQHS5JYKkOMA2', '', 'ROLE_MEMBRE'),
(3, 'user@ae.fr', 'Utilisateur', '$2a$10$Rweolpud/wUzZpaAt2Mohep3J89M4/jT8dPnXKT9D4QM.p3DaJiVe', 'Inscrit', 'ROLE_UTILISATEUR');

INSERT INTO `site` (`id`, `commune`, `cotation_maxi`, `cotation_mini`, `date_publication`, `departement`, `description`, `latitude`, `longitude`, `nbre_longueurs`, `nbre_relais`, `nbre_secteurs`, `nbre_voies`, `nom`, `pays`, `tag`, `utilisateur_id`) VALUES
(1, 'Valence', '6c', '4b', '2020-05-29 13:57:02.350000', 'Drôme', 'Un jolie site', 44.5, 5.5, 21, 16, 3, 8, 'Site 1', 'France', b'0', 1),
(2, 'Romans', '7c', '5b', '2020-05-29 13:57:02.362000', 'Drôme', 'Un jolie site', 44.5, 5.5, 21, 16, 3, 8, 'Site 2', 'France', b'0', 3),
(3, 'Valence', '8c', '3b', '2020-05-29 13:57:02.367000', 'Drôme', 'Un jolie site', 44.5, 5.5, 21, 16, 3, 8, 'Site 3', 'France', b'1', 1),
(4, 'Romans', '5c', '4b', '2020-05-29 13:57:02.393000', 'Drôme', 'Un jolie site', 44.5, 5.5, 21, 16, 3, 8, 'Site 4', 'France', b'0', 3),
(5, 'Valence', '6c', '5b', '2020-05-29 13:57:02.397000', 'Drôme', 'Un jolie site', 44.5, 5.5, 21, 16, 3, 8, 'Site 5', 'France', b'0', 1),
(6, 'Romans', '7c', '3b', '2020-05-29 13:57:02.400000', 'Drôme', 'Un jolie site', 44.5, 5.5, 21, 16, 3, 8, 'Site 6', 'France', b'1', 3),
(7, 'Valence', '8c', '4b', '2020-05-29 13:57:02.408000', 'Drôme', 'Un jolie site', 44.5, 5.5, 21, 16, 3, 8, 'Site 7', 'France', b'0', 1);

INSERT INTO `commentaire` (`id`, `contenu`, `date_modification`, `date_publication`, `utilisateur_id`, `site_id`) VALUES
(1, 'Voici le commentaire N° 1', '2020-05-29 13:57:02.416000', '2020-05-29 13:57:02.416000', 1, 1),
(2, 'Voici le commentaire N° 2', '2020-05-29 13:57:02.424000', '2020-05-29 13:57:02.424000', 1, 1),
(3, 'Voici le commentaire N° 3', '2020-05-29 13:57:02.429000', '2020-05-29 13:57:02.429000', 1, 1),
(4, 'Ceci est le commentaire N° 1', '2020-05-29 13:57:02.433000', '2020-05-29 13:57:02.433000', 3, 2),
(5, 'Ceci est le commentaire N° 2', '2020-05-29 13:57:02.437000', '2020-05-29 13:57:02.437000', 3, 2);

INSERT INTO `topo` (`id`, `date_publication`, `demande`, `description`, `disponible`, `region`, `titre`, `emprunteur_id`, `proprietaire_id`) VALUES
(1, '2020-05-29 13:57:02.440000', b'0', 'Ce topo décrit un topo du sud', b'0', 'La région du sud', 'Topo 1', NULL, 3),
(2, '2020-05-29 13:57:02.446000', b'0', 'Ce topo décrit un topo du sud', b'1', 'La région du sud', 'Topo 2', NULL, 1),
(3, '2020-05-29 13:57:02.449000', b'0', 'Ce topo décrit un topo du sud', b'0', 'La région du sud', 'Topo 3', NULL, 3),
(4, '2020-05-29 13:57:02.452000', b'0', 'Ce topo décrit un topo du sud', b'1', 'La région du sud', 'Topo 4', NULL, 1),
(5, '2020-05-29 13:57:02.454000', b'0', 'Ce topo décrit un topo du sud', b'0', 'La région du sud', 'Topo 5', NULL, 3),
(6, '2020-05-29 13:57:02.456000', b'0', 'Ce topo décrit un topo du sud', b'1', 'La région du sud', 'Topo 6', NULL, 1),
(7, '2020-05-29 13:57:02.460000', b'0', 'Ce topo décrit un topo du sud', b'0', 'La région du sud', 'Topo 7', NULL, 3),
(8, '2020-05-29 13:57:02.462000', b'0', 'Ce topo décrit un topo du sud', b'1', 'La région du sud', 'Topo 8', NULL, 1),
(9, '2020-05-29 13:57:02.464000', b'0', 'Ce topo décrit un topo du sud', b'0', 'La région du sud', 'Topo 9', NULL, 3);

