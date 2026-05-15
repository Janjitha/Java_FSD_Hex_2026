use crime_db;


-- -----------------------------------------------------
-- 1. Table `users` (12 Records)
-- -----------------------------------------------------
INSERT INTO `users` (`id`, `username`, `password`, `role`) VALUES
(1, 'head_admin1', 'pass123', 'station_head'),
(2, 'head_admin2', 'pass123', 'station_head'),
(3, 'head_admin3', 'pass123', 'station_head'),
(4, 'officer_smith', 'secure456', 'officer'),
(5, 'officer_davis', 'secure456', 'officer'),
(6, 'officer_jones', 'secure456', 'officer'),
(7, 'officer_miller', 'secure456', 'officer'),
(8, 'officer_wilson', 'secure456', 'officer'),
(9, 'officer_taylor', 'secure456', 'officer'),
(10, 'officer_brown', 'secure456', 'officer'),
(11, 'officer_white', 'secure456', 'officer'),
(12, 'officer_clark', 'secure456', 'officer');

-- -----------------------------------------------------
-- 2. Table `station_head` (3 Records)
-- -----------------------------------------------------
INSERT INTO `station_head` (`id`, `name`, `users_id`) VALUES
(101, 'Chief Edward Blake', 1),
(102, 'Chief Maria Santos', 2),
(103, 'Chief Thomas Wright', 3);

-- -----------------------------------------------------
-- 3. Table `station` (3 Records)
-- -----------------------------------------------------
INSERT INTO `station` (`id`, `station_title`, `adress`, `station_head_id`) VALUES
(201, 'Metro Central Station', '100 Downtown Blvd', 101),
(202, 'Northside Precinct', '452 Hiller Ave', 102),
(203, 'East Valley Station', '89 Orchard Rd', 103);

-- -----------------------------------------------------
-- 4. Table `officer` (9 Records)
-- -----------------------------------------------------
INSERT INTO `officer` (`id`, `name`, `users_id`, `station_id`) VALUES
(301, 'Officer John Smith', 4, 201),
(302, 'Officer Anna Davis', 5, 201),
(303, 'Officer Robert Jones', 6, 201),
(304, 'Officer David Miller', 7, 202),
(305, 'Officer Sarah Wilson', 8, 202),
(306, 'Officer James Taylor', 9, 202),
(307, 'Officer Michael Brown', 10, 203),
(308, 'Officer Emily White', 11, 203),
(309, 'Officer Kevin Clark', 12, 203);

-- -----------------------------------------------------
-- 5. Table `incident` (29 Records)
-- -----------------------------------------------------
INSERT INTO `incident` (`id`, `officer_id`, `type`, `progress_details`, `status`) VALUES
(1, 301, 'theft', 'Bicycle stolen from outside the library. Security footage requested.', 'initiated'),
(2, 301, 'murder', 'Crime scene cordoned off. Forensic team gathering fingerprint evidence.', 'active'),
(3, 302, 'missing person', 'Teenager failed to return home from school. Canvas of neighborhood completed.', 'active'),
(4, 302, 'report abuse', 'Domestic dispute report filed by neighbor. Statements taken from witnesses.', 'verified'),
(5, 303, 'theft', 'Shoplifting incident at electronics store. Suspect detained and items recovered.', 'closed'),
(6, 303, 'murder', 'Cold case review initiated. New DNA analysis requested on physical evidence.', 'initiated'),
(7, 304, 'missing person', 'Elderly man with dementia missing from care facility. Silver alert broadcasted.', 'active'),
(8, 304, 'report abuse', 'Verbal harassment reported at workplace. Human Resources notified.', 'verified'),
(9, 305, 'theft', 'Wallet stolen on public transit. Credit card tracking initiated.', 'initiated'),
(10, 305, 'theft', 'Vehicle broken into overnight. Dashboard camera footage extracted.', 'active'),
(11, 306, 'murder', 'Suspect apprehended at border crossing. Interrogation scheduled.', 'verified'),
(12, 306, 'report abuse', 'Anonymously reported child neglect case. Welfare check conducted by team.', 'active'),
(13, 307, 'missing person', 'Hiker missing in state park. Search and rescue teams deployed.', 'active'),
(14, 307, 'theft', 'Armed robbery at convenience store. Cash and merchandise stolen.', 'initiated'),
(15, 308, 'report abuse', 'Online cyberbullying complaint filed. IP address tracing requested.', 'initiated'),
(16, 308, 'murder', 'Trial finalized. Defendant found guilty on all charges.', 'closed'),
(17, 309, 'missing person', 'Missing child located safely at a friend\'s residence. Case resolved.', 'closed'),
(18, 309, 'theft', 'Burglary at residential property. Jewelry and electronics reported missing.', 'active'),
(19, 301, 'report abuse', 'Elder financial abuse allegation. Bank statements subpoenaed for review.', 'active'),
(20, 302, 'murder', 'Primary suspect identified via security camera analysis. Warrant issued.', 'active'),
(21, 303, 'theft', 'Pickpocketing reported at downtown festival. No suspect description available.', 'initiated'),
(22, 304, 'missing person', 'Runaway juvenile located and returned to legal guardians.', 'closed'),
(23, 305, 'report abuse', 'Physical altercation at restaurant. CCTV footage secured.', 'verified'),
(24, 306, 'theft', 'Commercial burglary at warehouse. Inventory audit underway.', 'active'),
(25, 307, 'murder', 'Weapon recovered from riverbed. Sent to ballistics lab for verification.', 'verified'),
(26, 308, 'missing person', 'Missing tourist contact established. Safe in alternative hotel.', 'closed'),
(27, 309, 'theft', 'Stolen vehicle recovered abandoned on highway. Towed for prints.', 'closed'),
(28, 301, 'report abuse', 'Tenant harassment complaint against landlord. Documentation filed.', 'initiated'),
(29, 302, 'theft', 'Package theft from front porch. Ring doorbell footage collected.', 'active');

-- Display all incidents handled by particular officer name. 

select i.id,i.type,i.status   
from incident i JOIN officer o ON i.officer_id = o.id
where o.name LIKE '%john smith%';

/*
+----+--------------+-----------+
| id | type         | status    |
+----+--------------+-----------+
|  1 | theft        | initiated |
|  2 | murder       | active    |
| 19 | report abuse | active    |
| 28 | report abuse | initiated |
+----+--------------+-----------+
*/

-- Give me the details of Station master responsible for incident ID:22 

select sh.name as "Station Head", o.name as "Handling Officer", i.type as "Incident", i.progress_details as "Incident Report"
from station_head sh 
JOIN station s ON sh.id = s.station_head_id 
JOIN officer o ON s.id = o.station_id 
JOIN incident i ON o.id = i.officer_id 
where i.id=22;
















