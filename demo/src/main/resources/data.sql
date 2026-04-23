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
                                                                                                                                 ('C1-M8', 'Nom membre 8', 'Prénom membre 6', '1975-08-20', 'M', 'Lot UV 8 Ambato', 'Riziculteur', '0370234567', 'member.8@fed-agri.mg', 'Confirmé', 'col-1');

INSERT INTO members (id, last_name, first_name, birth_date, gender, address, job, phone, email, occupation, collectivity_id) VALUES
                                                                                                                                 ('C2-M1', 'Nom membre 1', 'Prénom membre 1', '1980-02-01', 'M', 'Lot II V M Ambato', 'Riziculteur', '0341234567', 'member.1@fed-agri.mg', 'Confirmé', 'col-2'),
                                                                                                                                 ('C2-M2', 'Nom membre 2', 'Prénom membre 2', '1982-03-05', 'M', 'Lot II F Ambato', 'Agriculteur', '0321234567', 'member.2@fed-agri.mg', 'Confirmé', 'col-2'),
                                                                                                                                 ('C2-M3', 'Nom membre 3', 'Prénom membre 3', '1992-03-10', 'M', 'Lot II J Ambato', 'Collecteur', '0331234567', 'member.3@fed-agri.mg', 'Confirmé', 'col-2'),
                                                                                                                                 ('C2-M4', 'Nom membre 4', 'Prénom membre 4', '1988-05-22', 'F', 'Lot A K 50 Ambato', 'Distributeur', '0381234567', 'member.4@fed-agri.mg', 'Confirmé', 'col-2'),
                                                                                                                                 ('C2-M5', 'Nom membre 5', 'Prénom membre 5', '1999-08-21', 'M', 'Lot UV 80 Ambato', 'Riziculteur', '0373434567', 'member.5@fed-agri.mg', 'Président', 'col-2'),
                                                                                                                                 ('C2-M6', 'Nom membre 6', 'Prénom membre 6', '1998-08-22', 'F', 'Lot UV 6 Ambato', 'Riziculteur', '0372234567', 'member.6@fed-agri.mg', 'Vice président', 'col-2'),
                                                                                                                                 ('C2-M7', 'Nom membre 7', 'Prénom membre 7', '1998-01-31', 'M', 'Lot UV 7 Ambato', 'Riziculteur', '0374234567', 'member.7@fed-agri.mg', 'Secrétaire', 'col-2'),
                                                                                                                                 ('C2-M8', 'Nom membre 8', 'Prénom membre 8', '1975-08-20', 'M', 'Lot UV 8 Ambato', 'Riziculteur', '0370234567', 'member.8@fed-agri.mg', 'Trésorier', 'col-2');

INSERT INTO members (id, last_name, first_name, birth_date, gender, address, job, phone, email, occupation, collectivity_id) VALUES
                                                                                                                                 ('C3-M1', 'Nom membre 9', 'Prénom membre 9', '1988-01-02', 'M', 'Lot 33 J Antsirabe', 'Apiculteur', '034034567', 'member.9@fed-agri.mg', 'Président', 'col-3'),
                                                                                                                                 ('C3-M2', 'Nom membre 10', 'Prénom membre 10', '1982-03-05', 'M', 'Lot 2 J Antsirabe', 'Agriculteur', '0338634567', 'member.10@fed-agri.mg', 'Vice président', 'col-3'),
                                                                                                                                 ('C3-M3', 'Nom membre 11', 'Prénom membre 11', '1992-03-12', 'M', 'Lot 8 KM Antsirabe', 'Collecteur', '0338234567', 'member.11@fed-agri.mg', 'Secrétaire', 'col-3'),
                                                                                                                                 ('C3-M4', 'Nom membre 12', 'Prénom membre 12', '1988-05-10', 'F', 'Lot A K 50 Antsirabe', 'Distributeur', '0382334567', 'member.12@fed-agri.mg', 'Trésorier', 'col-3'),
                                                                                                                                 ('C3-M5', 'Nom membre 13', 'Prénom membre 13', '1999-08-11', 'M', 'Lot UV 80 Antsirabe', 'Apiculteur', '0373365567', 'member.13@fed-agri.mg', 'Confirmé', 'col-3'),
                                                                                                                                 ('C3-M6', 'Nom membre 14', 'Prénom membre 14', '1998-08-09', 'F', 'Lot UV 6 Antsirabe', 'Apiculteur', '0378234567', 'member.14@fed-agri.mg', 'Confirmé', 'col-3'),
                                                                                                                                 ('C3-M7', 'Nom membre 15', 'Prénom membre 15', '1998-01-13', 'M', 'Lot UV 7 Antsirabe', 'Apiculteur', '0374914567', 'member.15@fed-agri.mg', 'Confirmé', 'col-3'),
                                                                                                                                 ('C3-M8', 'Nom membre 16', 'Prénom membre 16', '1975-08-02', 'M', 'Lot UV 8 Antsirabe', 'Apiculteur', '0370634567', 'member.16@fed-agri.mg', 'Confirmé', 'col-3');

INSERT INTO sponsorships (member_id, sponsor_id) VALUES
                                                     ('C1-M3', 'C1-M1'), ('C1-M3', 'C1-M2'), ('C1-M4', 'C1-M1'), ('C1-M4', 'C1-M2'),
                                                     ('C1-M5', 'C1-M1'), ('C1-M5', 'C1-M2'), ('C1-M6', 'C1-M1'), ('C1-M6', 'C1-M2'),
                                                     ('C1-M7', 'C1-M1'), ('C1-M7', 'C1-M2'), ('C1-M8', 'C1-M6'), ('C1-M8', 'C1-M7');

INSERT INTO sponsorships (member_id, sponsor_id) VALUES
                                                     ('C2-M3', 'C1-M1'), ('C2-M3', 'C1-M2'), ('C2-M4', 'C1-M1'), ('C2-M4', 'C1-M2'),
                                                     ('C2-M5', 'C1-M1'), ('C2-M5', 'C1-M2'), ('C2-M6', 'C1-M1'), ('C2-M6', 'C1-M2'),
                                                     ('C2-M7', 'C1-M1'), ('C2-M7', 'C1-M2'), ('C2-M8', 'C1-M6'), ('C2-M8', 'C1-M7');

INSERT INTO sponsorships (member_id, sponsor_id) VALUES
                                                     ('C3-M1', 'C1-M1'), ('C3-M1', 'C1-M2'), ('C3-M2', 'C1-M1'), ('C3-M2', 'C1-M2'),
                                                     ('C3-M3', 'C3-M1'), ('C3-M3', 'C3-M2'), ('C3-M4', 'C3-M1'), ('C3-M4', 'C3-M2'),
                                                     ('C3-M5', 'C3-M1'), ('C3-M5', 'C3-M2'), ('C3-M6', 'C3-M1'), ('C3-M6', 'C3-M2'),
                                                     ('C3-M7', 'C3-M1'), ('C3-M7', 'C3-M2'), ('C3-M8', 'C3-M1'), ('C3-M8', 'C3-M2');

INSERT INTO membership_fees (id, label, status, frequency, eligible_since, amount, collectivity_id) VALUES
                                                                                                        ('cot-1', 'Cotisation annuelle', 'ACTIVE', 'ANNUALLY', '2026-01-01', 100000, 'col-1'),
                                                                                                        ('cot-2', 'Cotisation annuelle', 'ACTIVE', 'ANNUALLY', '2026-01-01', 100000, 'col-2'),
                                                                                                        ('cot-3', 'Cotisation annuelle', 'ACTIVE', 'ANNUALLY', '2026-01-01', 50000, 'col-3');

INSERT INTO accounts (id, collectivity_id, type, holder_name, phone_number, balance) VALUES
                                                                                         ('C1-A-CASH', 'col-1', 'CASH', NULL, NULL, 0.0),
                                                                                         ('C1-A-MOBILE-1', 'col-1', 'MOBILE_MONEY', 'Mpanorina', '0370489612', 0.0),
                                                                                         ('C2-A-CASH', 'col-2', 'CASH', NULL, NULL, 0.0),
                                                                                         ('C2-A-MOBILE-1', 'col-2', 'MOBILE_MONEY', 'Dobo voalohany', '0320489612', 0.0),
                                                                                         ('C3-A-CASH', 'col-3', 'CASH', NULL, NULL, 0.0);

INSERT INTO member_payments (id, member_id, amount, payment_mode, account_id, creation_date) VALUES
                                                                                                 ('P-C1-01', 'C1-M1', 100000, 'CASH', 'C1-A-CASH', '2026-01-01'),
                                                                                                 ('P-C1-02', 'C1-M2', 100000, 'CASH', 'C1-A-CASH', '2026-01-01'),
                                                                                                 ('P-C1-03', 'C1-M3', 100000, 'CASH', 'C1-A-CASH', '2026-01-01'),
                                                                                                 ('P-C1-04', 'C1-M4', 100000, 'CASH', 'C1-A-CASH', '2026-01-01'),
                                                                                                 ('P-C1-05', 'C1-M5', 100000, 'CASH', 'C1-A-CASH', '2026-01-01'),
                                                                                                 ('P-C1-06', 'C1-M6', 100000, 'CASH', 'C1-A-CASH', '2026-01-01'),
                                                                                                 ('P-C1-07', 'C1-M7', 60000, 'CASH', 'C1-A-CASH', '2026-01-01'),
                                                                                                 ('P-C1-08', 'C1-M8', 90000, 'CASH', 'C1-A-CASH', '2026-01-01');

INSERT INTO collectivity_transactions (id, amount, creation_date, account_id, member_debited_id) VALUES
                                                                                                     ('T-C1-01', 100000, '2026-01-01', 'C1-A-CASH', 'C1-M1'),
                                                                                                     ('T-C1-02', 100000, '2026-01-01', 'C1-A-CASH', 'C1-M2'),
                                                                                                     ('T-C1-03', 100000, '2026-01-01', 'C1-A-CASH', 'C1-M3'),
                                                                                                     ('T-C1-04', 100000, '2026-01-01', 'C1-A-CASH', 'C1-M4'),
                                                                                                     ('T-C1-05', 100000, '2026-01-01', 'C1-A-CASH', 'C1-M5'),
                                                                                                     ('T-C1-06', 100000, '2026-01-01', 'C1-A-CASH', 'C1-M6'),
                                                                                                     ('T-C1-07', 60000, '2026-01-01', 'C1-A-CASH', 'C1-M7'),
                                                                                                     ('T-C1-08', 90000, '2026-01-01', 'C1-A-CASH', 'C1-M8');

INSERT INTO member_payments (id, member_id, amount, payment_mode, account_id, creation_date) VALUES
                                                                                                 ('P-C2-01', 'C2-M1', 60000, 'CASH', 'C2-A-CASH', '2026-01-01'),
                                                                                                 ('P-C2-02', 'C2-M2', 90000, 'CASH', 'C2-A-CASH', '2026-01-01'),
                                                                                                 ('P-C2-03', 'C2-M3', 100000, 'CASH', 'C2-A-CASH', '2026-01-01'),
                                                                                                 ('P-C2-04', 'C2-M4', 100000, 'CASH', 'C2-A-CASH', '2026-01-01'),
                                                                                                 ('P-C2-05', 'C2-M5', 100000, 'CASH', 'C2-A-CASH', '2026-01-01'),
                                                                                                 ('P-C2-06', 'C2-M6', 100000, 'CASH', 'C2-A-CASH', '2026-01-01'),
                                                                                                 ('P-C2-07', 'C2-M7', 40000, 'MOBILE_MONEY', 'C2-A-MOBILE-1', '2026-01-01'),
                                                                                                 ('P-C2-08', 'C2-M8', 60000, 'MOBILE_MONEY', 'C2-A-MOBILE-1', '2026-01-01');

INSERT INTO collectivity_transactions (id, amount, creation_date, account_id, member_debited_id) VALUES
                                                                                                     ('T-C2-01', 60000, '2026-01-01', 'C2-A-CASH', 'C2-M1'),
                                                                                                     ('T-C2-02', 90000, '2026-01-01', 'C2-A-CASH', 'C2-M2'),
                                                                                                     ('T-C2-03', 100000, '2026-01-01', 'C2-A-CASH', 'C2-M3'),
                                                                                                     ('T-C2-04', 100000, '2026-01-01', 'C2-A-CASH', 'C2-M4'),
                                                                                                     ('T-C2-05', 100000, '2026-01-01', 'C2-A-CASH', 'C2-M5'),
                                                                                                     ('T-C2-06', 100000, '2026-01-01', 'C2-A-CASH', 'C2-M6'),
                                                                                                     ('T-C2-07', 40000, '2026-01-01', 'C2-A-MOBILE-1', 'C2-M7'),
                                                                                                     ('T-C2-08', 60000, '2026-01-01', 'C2-A-MOBILE-1', 'C2-M8');