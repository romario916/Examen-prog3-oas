TRUNCATE activity_member_attendance, collectivity_activities, member_payments,
         collectivity_transactions, membership_fees, accounts, sponsorships,
         members, collectivities CASCADE;

INSERT INTO collectivities (id, unique_number, name, location, specialty) VALUES
                                                                              ('col-1', 1, 'Mpanorina', 'Ambatondrazaka', 'Riziculture'),
                                                                              ('col-2', 2, 'Dobo voalohany', 'Ambatondrazaka', 'Pisciculture'),
                                                                              ('col-3', 3, 'Tantely mamy', 'Brickaville', 'Apiculture');

INSERT INTO members (id, last_name, first_name, birth_date, gender, address, job, phone, email, occupation, collectivity_id) VALUES
                                                                                                                                 ('C1-M1', 'Nom membre 1', 'Prénom membre 1', '1980-02-01', 'M', 'Lot II V M Ambato', 'Riziculteur', '0341234567', 'member.1@fed-agri.mg', 'Président', 'col-1'),
                                                                                                                                 ('C1-M2', 'Nom membre 2', 'Prénom membre 2', '1982-03-05', 'M', 'Lot II F Ambato', 'Agriculteur', '0321234567', 'member.2@fed-agri.mg', 'Vice président', 'col-1'),
                                                                                                                                 ('C1-M3', 'Nom membre 3', 'Prénom membre 3', '1992-03-10', 'M', 'Lot II J Ambato', 'Collecteur', '0331234567', 'member.3@fed-agri.mg', 'Secrétaire', 'col-1'),
                                                                                                                                 ('C1-M4', 'Nom membre 4', 'Prénom membre 4', '1988-05-22', 'F', 'Lot A K 50 Ambato', 'Distributeur', '0381234567', 'member.4@fed-agri.mg', 'Trésorier', 'col-1'),
                                                                                                                                 ('C1-M5', 'Nom membre 5', 'Prénom membre 5', '1999-08-21', 'M', 'Lot UV 80 Ambato', 'Riziculteur', '0373434567', 'member.5@fed-agri.mg', 'Confirmé', 'col-1'),
                                                                                                                                 ('C1-M6', 'Nom membre 6', 'Prénom membre 6', '1998-08-22', 'F', 'Lot UV 6 Ambato', 'Riziculteur', '0372234567', 'member.6@fed-agri.mg', 'Confirmé', 'col-1'),
                                                                                                                                 ('C1-M7', 'Nom membre 7', 'Prénom membre 7', '1998-01-31', 'M', 'Lot UV 7 Ambato', 'Riziculteur', '0374234567', 'member.7@fed-agri.mg', 'Confirmé', 'col-1'),
                                                                                                                                 ('C1-M8', 'Nom membre 8', 'Prénom membre 6', '1975-08-20', 'M', 'Lot UV 8 Ambato', 'Riziculteur', '0370234567', 'member.8@fed-agri.mg', 'Confirmé', 'col-1'),
                                                                                                                                 ('C3-M1', 'Nom membre 9', 'Prénom membre 9', '1988-01-02', 'M', 'Lot 33 J Antsirabe', 'Apiculteur', '034034567', 'member.9@fed-agri.mg', 'Président', 'col-3'),
                                                                                                                                 ('C3-M2', 'Nom membre 10', 'Prénom membre 10', '1982-03-05', 'M', 'Lot 2 J Antsirabe', 'Agriculteur', '0338634567', 'member.10@fed-agri.mg', 'Vice président', 'col-3'),
                                                                                                                                 ('C3-M3', 'Nom membre 11', 'Prénom membre 11', '1992-03-12', 'M', 'Lot 8 KM Antsirabe', 'Collecteur', '0338234567', 'member.11@fed-agri.mg', 'Secrétaire', 'col-3'),
                                                                                                                                 ('C3-M4', 'Nom membre 12', 'Prénom membre 12', '1988-05-10', 'F', 'Lot A K 50 Antsirabe', 'Distributeur', '0382334567', 'member.12@fed-agri.mg', 'Trésorier', 'col-3'),
                                                                                                                                 ('C3-M5', 'Nom membre 13', 'Prénom membre 13', '1999-08-11', 'M', 'Lot UV 80 Antsirabe', 'Apiculteur', '0373365567', 'member.13@fed-agri.mg', 'Confirmé', 'col-3'),
                                                                                                                                 ('C3-M6', 'Nom membre 14', 'Prénom membre 14', '1998-08-09', 'F', 'Lot UV 6 Antsirabe', 'Apiculteur', '0378234567', 'member.14@fed-agri.mg', 'Confirmé', 'col-3'),
                                                                                                                                 ('C3-M7', 'Nom membre 15', 'Prénom membre 15', '1998-01-13', 'M', 'Lot UV 7 Antsirabe', 'Apiculteur', '0374914567', 'member.15@fed-agri.mg', 'Confirmé', 'col-3'),
                                                                                                                                 ('C3-M8', 'Nom membre 16', 'Prénom membre 16', '1975-08-02', 'M', 'Lot UV 8 Antsirabe', 'Apiculteur', '0370634567', 'member.16@fed-agri.mg', 'Confirmé', 'col-3');

INSERT INTO collectivity_activities (id, collectivity_id, label, activity_type, recurrence_rule, executive_date) VALUES
                                                                                                                     ('act-1', 'col-1', 'AG1', 'MEETING', '1er samedi de chaque mois', NULL),
                                                                                                                     ('act-2', 'col-1', 'Formation de base', 'TRAINING', '2è dimanche de chaque mois', NULL),
                                                                                                                     ('act-6', 'col-3', 'AG3', 'MEETING', NULL, '2026-03-06');

INSERT INTO activity_member_attendance (activity_id, member_id, attendance_status) VALUES
                                                                                       ('act-6', 'C3-M1', 'ATTENDED'), ('act-6', 'C3-M2', 'ATTENDED'),
                                                                                       ('act-6', 'C3-M3', 'ATTENDED'), ('act-6', 'C3-M4', 'ATTENDED'),
                                                                                       ('act-6', 'C3-M5', 'ATTENDED'), ('act-6', 'C3-M6', 'ATTENDED'),
                                                                                       ('act-6', 'C3-M7', 'MISSING'),  ('act-6', 'C3-M8', 'MISSING');

INSERT INTO membership_fees (id, label, status, frequency, eligible_since, amount, collectivity_id) VALUES
    ('cot-3', 'Cotisation annuelle', 'ACTIVE', 'ANNUALLY', '2026-01-01', 50000, 'col-3');

INSERT INTO accounts (id, collectivity_id, type, balance) VALUES
    ('C3-A-CASH', 'col-3', 'CASH', 0.0);