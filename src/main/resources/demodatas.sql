INSERT INTO `utilisateur` (`id`, `email`, `nom`, `password`, `prenom`, `role`) VALUES
(1, 'admin@ae.fr', 'Administrateur', '$2a$10$Ed5C6Fu.cQJEp4FG6GjjAOSzE6a/NJ1UFJxHBz6X3QURDMassvGyW', '', 'ROLE_ADMINISTRATEUR'),
(2, 'member@ae.fr', 'Membre', '$2a$10$7H9uCf6UdgiDT1z05rnvOe/iqkA4ZxzAzmVUy5BgQQHS5JYKkOMA2', '', 'ROLE_MEMBRE'),
(3, 'user@ae.fr', 'Utilisateur', '$2a$10$Rweolpud/wUzZpaAt2Mohep3J89M4/jT8dPnXKT9D4QM.p3DaJiVe', 'Inscrit', 'ROLE_UTILISATEUR');

INSERT INTO `site` (`id`, `commune`, `cotation_maxi`, `cotation_mini`, `date_publication`, `departement`, `description`, `latitude`, `longitude`, `nbre_longueurs`, `nbre_relais`, `nbre_secteurs`, `nbre_voies`, `nom`, `pays`, `tag`, `utilisateur_id`) VALUES
(1, 'Valence', '6c', '4b', '2020-05-25 11:57:00', 'Drôme', 'Un jolie site', 44.5, 5.5, 21, 16, 3, 8, 'Site du Parc', 'France', b'0', 1),
(2, 'Romans', '7c', '5b', '2020-05-25 17:32:02', 'Drôme', 'Un site parfait', 44.5, 5.5, 21, 16, 3, 8, 'Le bois de Romans', 'France', b'0', 3),
(3, 'Malissard', '8c', '3b', '2020-05-26 09:16:00', 'Drôme', 'Site très technique', 44.5, 5.5, 21, 16, 3, 8, 'Site de l''école d''escalade', 'France', b'1', 1),
(4, 'Romans', '5a', '3a', '2020-05-26 10:44:02', 'Drôme', 'Site parfait pour les enfants', 44.5, 5.5, 21, 16, 3, 8, 'Les sentiers de bidule', 'France', b'0', 2),
(5, 'Valence', '6c', '5b', '2020-05-27 14:30:00', 'Drôme', 'Escalade du richer de Crussol', 44.5, 5.5, 21, 16, 3, 8, 'Montagne de Crussol', 'France', b'0', 1),
(6, 'Avignon', '7c', '3b', '2020-05-28 21:07:12', 'Vaucluse', 'Mur d''escalade', 44.5, 5.5, 21, 16, 3, 8, 'Palais des Papes', 'France', b'1', 3),
(7, 'Nîmes', '8c', '4b', '2020-05-29 12:01:00', 'Gard', 'L''escalade du pont du Gard', 44.5, 5.5, 21, 16, 3, 8, 'Pont du Gard', 'France', b'0', 2);

INSERT INTO `commentaire` (`id`, `contenu`, `date_modification`, `date_publication`, `utilisateur_id`, `site_id`) VALUES
(1, 'Site découvert aujourd''hui', '2020-05-25 13:31:02', '2020-05-25 13:31:02', 1, 1),
(2, 'J''y suis allé, il est très bien', '2020-05-27 08:15:00', '2020-05-27 08:15:00', 2, 1),
(3, 'Je suis content qu''il vous plaise', '2020-05-29 19:07:02', '2020-05-29 19:07:02', 3, 1),
(4, 'Lieu d''escalade très ombragé', '2020-05-26 11:19:02', '2020-05-26 11:19:02', 3, 2),
(5, 'Tu as bien raison', '2020-05-26 11:21:02', '2020-05-26 11:21:02', 1, 2);

INSERT INTO `topo` (`id`, `date_publication`, `demande`, `description`, `disponible`, `region`, `titre`, `emprunteur_id`, `proprietaire_id`) VALUES
(1, '2020-05-29 13:57:02', b'0', 'Ce topo décrit un topo du sud', b'1', 'La région du sud', 'Topo de Valence', NULL, 3),
(2, '2020-05-29 13:57:02', b'0', 'Ce topo décrit un topo du sud', b'1', 'La région du sud', 'Topo guide de la Drôme', NULL, 1),
(3, '2020-05-29 13:57:02', b'0', 'Ce topo décrit un topo du sud', b'1', 'La région du sud', 'Topo d''Avignon', NULL, 3);
