DELETE FROM `topo`;
DELETE FROM `commentaire`;
DELETE FROM `site`;
DELETE FROM `utilisateur`;

INSERT INTO `utilisateur` (`id`, `email`, `nom`, `password`, `prenom`, `role`) VALUES
(1, 'admin@ae.fr', 'Administrateur', '$2a$10$Ed5C6Fu.cQJEp4FG6GjjAOSzE6a/NJ1UFJxHBz6X3QURDMassvGyW', '', 'ROLE_ADMINISTRATEUR');