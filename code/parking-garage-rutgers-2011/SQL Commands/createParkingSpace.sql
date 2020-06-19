/*Brian Goodacre*/
USE parkinggarage;

DROP TABLE parkingSpaces;

CREATE TABLE parkingSpaces (
	parkingSpaceID INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	char_handicap INT(1) DEFAULT 0,
	
	currentReservationID INT(10),
	time20110101_0000 INT(10),
	time20110101_0015 INT(10),
	time20110101_0030 INT(10),
	time20110101_0045 INT(10),
	time20110101_0100 INT(10),
	time20110101_0115 INT(10),
	time20110101_0130 INT(10),
	time20110101_0145 INT(10),
	time20110101_0200 INT(10),
	time20110101_0215 INT(10),
	time20110101_0230 INT(10),
	time20110101_0245 INT(10),
	
	time20110504_0000 INT(10),
time20110504_0015 INT(10),
time20110504_0030 INT(10),
time20110504_0045 INT(10),
time20110504_0100 INT(10),
time20110504_0115 INT(10),
time20110504_0130 INT(10),
time20110504_0145 INT(10),
time20110504_0200 INT(10),
time20110504_0215 INT(10),
time20110504_0230 INT(10),
time20110504_0245 INT(10),
time20110504_0300 INT(10),
time20110504_0315 INT(10),
time20110504_0330 INT(10),
time20110504_0345 INT(10),
time20110504_0400 INT(10),
time20110504_0415 INT(10),
time20110504_0430 INT(10),
time20110504_0445 INT(10),
time20110504_0500 INT(10),
time20110504_0515 INT(10),
time20110504_0530 INT(10),
time20110504_0545 INT(10),
time20110504_0600 INT(10),
time20110504_0615 INT(10),
time20110504_0630 INT(10),
time20110504_0645 INT(10),
time20110504_0700 INT(10),
time20110504_0715 INT(10),
time20110504_0730 INT(10),
time20110504_0745 INT(10),
time20110504_0800 INT(10),
time20110504_0815 INT(10),
time20110504_0830 INT(10),
time20110504_0845 INT(10),
time20110504_0900 INT(10),
time20110504_0915 INT(10),
time20110504_0930 INT(10),
time20110504_0945 INT(10),
time20110504_1000 INT(10),
time20110504_1015 INT(10),
time20110504_1030 INT(10),
time20110504_1045 INT(10),
time20110504_1100 INT(10),
time20110504_1115 INT(10),
time20110504_1130 INT(10),
time20110504_1145 INT(10),
time20110504_1200 INT(10),
time20110504_1215 INT(10),
time20110504_1230 INT(10),
time20110504_1245 INT(10),
time20110504_1300 INT(10),
time20110504_1315 INT(10),
time20110504_1330 INT(10),
time20110504_1345 INT(10),
time20110504_1400 INT(10),
time20110504_1415 INT(10),
time20110504_1430 INT(10),
time20110504_1445 INT(10),
time20110504_1500 INT(10),
time20110504_1515 INT(10),
time20110504_1530 INT(10),
time20110504_1545 INT(10),
time20110504_1600 INT(10),
time20110504_1615 INT(10),
time20110504_1630 INT(10),
time20110504_1645 INT(10),
time20110504_1700 INT(10),
time20110504_1715 INT(10),
time20110504_1730 INT(10),
time20110504_1745 INT(10),
time20110504_1800 INT(10),
time20110504_1815 INT(10),
time20110504_1830 INT(10),
time20110504_1845 INT(10),
time20110504_1900 INT(10),
time20110504_1915 INT(10),
time20110504_1930 INT(10),
time20110504_1945 INT(10),
time20110504_2000 INT(10),
time20110504_2015 INT(10),
time20110504_2030 INT(10),
time20110504_2045 INT(10),
time20110504_2100 INT(10),
time20110504_2115 INT(10),
time20110504_2130 INT(10),
time20110504_2145 INT(10),
time20110504_2200 INT(10),
time20110504_2215 INT(10),
time20110504_2230 INT(10),
time20110504_2245 INT(10),
time20110504_2300 INT(10),
time20110504_2315 INT(10),
time20110504_2330 INT(10),
time20110504_2345 INT(10),
time20110505_0000 INT(10),
time20110505_0015 INT(10),
time20110505_0030 INT(10),
time20110505_0045 INT(10),
time20110505_0100 INT(10),
time20110505_0115 INT(10),
time20110505_0130 INT(10),
time20110505_0145 INT(10),
time20110505_0200 INT(10),
time20110505_0215 INT(10),
time20110505_0230 INT(10),
time20110505_0245 INT(10),
time20110505_0300 INT(10),
time20110505_0315 INT(10),
time20110505_0330 INT(10),
time20110505_0345 INT(10),
time20110505_0400 INT(10),
time20110505_0415 INT(10),
time20110505_0430 INT(10),
time20110505_0445 INT(10),
time20110505_0500 INT(10),
time20110505_0515 INT(10),
time20110505_0530 INT(10),
time20110505_0545 INT(10),
time20110505_0600 INT(10),
time20110505_0615 INT(10),
time20110505_0630 INT(10),
time20110505_0645 INT(10),
time20110505_0700 INT(10),
time20110505_0715 INT(10),
time20110505_0730 INT(10),
time20110505_0745 INT(10),
time20110505_0800 INT(10),
time20110505_0815 INT(10),
time20110505_0830 INT(10),
time20110505_0845 INT(10),
time20110505_0900 INT(10),
time20110505_0915 INT(10),
time20110505_0930 INT(10),
time20110505_0945 INT(10),
time20110505_1000 INT(10),
time20110505_1015 INT(10),
time20110505_1030 INT(10),
time20110505_1045 INT(10),
time20110505_1100 INT(10),
time20110505_1115 INT(10),
time20110505_1130 INT(10),
time20110505_1145 INT(10),
time20110505_1200 INT(10),
time20110505_1215 INT(10),
time20110505_1230 INT(10),
time20110505_1245 INT(10),
time20110505_1300 INT(10),
time20110505_1315 INT(10),
time20110505_1330 INT(10),
time20110505_1345 INT(10),
time20110505_1400 INT(10),
time20110505_1415 INT(10),
time20110505_1430 INT(10),
time20110505_1445 INT(10),
time20110505_1500 INT(10),
time20110505_1515 INT(10),
time20110505_1530 INT(10),
time20110505_1545 INT(10),
time20110505_1600 INT(10),
time20110505_1615 INT(10),
time20110505_1630 INT(10),
time20110505_1645 INT(10),
time20110505_1700 INT(10),
time20110505_1715 INT(10),
time20110505_1730 INT(10),
time20110505_1745 INT(10),
time20110505_1800 INT(10),
time20110505_1815 INT(10),
time20110505_1830 INT(10),
time20110505_1845 INT(10),
time20110505_1900 INT(10),
time20110505_1915 INT(10),
time20110505_1930 INT(10),
time20110505_1945 INT(10),
time20110505_2000 INT(10),
time20110505_2015 INT(10),
time20110505_2030 INT(10),
time20110505_2045 INT(10),
time20110505_2100 INT(10),
time20110505_2115 INT(10),
time20110505_2130 INT(10),
time20110505_2145 INT(10),
time20110505_2200 INT(10),
time20110505_2215 INT(10),
time20110505_2230 INT(10),
time20110505_2245 INT(10),
time20110505_2300 INT(10),
time20110505_2315 INT(10),
time20110505_2330 INT(10),
time20110505_2345 INT(10),

	
	time20110506_0000 INT(10),
time20110506_0015 INT(10),
time20110506_0030 INT(10),
time20110506_0045 INT(10),
time20110506_0100 INT(10),
time20110506_0115 INT(10),
time20110506_0130 INT(10),
time20110506_0145 INT(10),
time20110506_0200 INT(10),
time20110506_0215 INT(10),
time20110506_0230 INT(10),
time20110506_0245 INT(10),
time20110506_0300 INT(10),
time20110506_0315 INT(10),
time20110506_0330 INT(10),
time20110506_0345 INT(10),
time20110506_0400 INT(10),
time20110506_0415 INT(10),
time20110506_0430 INT(10),
time20110506_0445 INT(10),
time20110506_0500 INT(10),
time20110506_0515 INT(10),
time20110506_0530 INT(10),
time20110506_0545 INT(10),
time20110506_0600 INT(10),
time20110506_0615 INT(10),
time20110506_0630 INT(10),
time20110506_0645 INT(10),
time20110506_0700 INT(10),
time20110506_0715 INT(10),
time20110506_0730 INT(10),
time20110506_0745 INT(10),
time20110506_0800 INT(10),
time20110506_0815 INT(10),
time20110506_0830 INT(10),
time20110506_0845 INT(10),
time20110506_0900 INT(10),
time20110506_0915 INT(10),
time20110506_0930 INT(10),
time20110506_0945 INT(10),
time20110506_1000 INT(10),
time20110506_1015 INT(10),
time20110506_1030 INT(10),
time20110506_1045 INT(10),
time20110506_1100 INT(10),
time20110506_1115 INT(10),
time20110506_1130 INT(10),
time20110506_1145 INT(10),
time20110506_1200 INT(10),
time20110506_1215 INT(10),
time20110506_1230 INT(10),
time20110506_1245 INT(10),
time20110506_1300 INT(10),
time20110506_1315 INT(10),
time20110506_1330 INT(10),
time20110506_1345 INT(10),
time20110506_1400 INT(10),
time20110506_1415 INT(10),
time20110506_1430 INT(10),
time20110506_1445 INT(10),
time20110506_1500 INT(10),
time20110506_1515 INT(10),
time20110506_1530 INT(10),
time20110506_1545 INT(10),
time20110506_1600 INT(10),
time20110506_1615 INT(10),
time20110506_1630 INT(10),
time20110506_1645 INT(10),
time20110506_1700 INT(10),
time20110506_1715 INT(10),
time20110506_1730 INT(10),
time20110506_1745 INT(10),
time20110506_1800 INT(10),
time20110506_1815 INT(10),
time20110506_1830 INT(10),
time20110506_1845 INT(10),
time20110506_1900 INT(10),
time20110506_1915 INT(10),
time20110506_1930 INT(10),
time20110506_1945 INT(10),
time20110506_2000 INT(10),
time20110506_2015 INT(10),
time20110506_2030 INT(10),
time20110506_2045 INT(10),
time20110506_2100 INT(10),
time20110506_2115 INT(10),
time20110506_2130 INT(10),
time20110506_2145 INT(10),
time20110506_2200 INT(10),
time20110506_2215 INT(10),
time20110506_2230 INT(10),
time20110506_2245 INT(10),
time20110506_2300 INT(10),
time20110506_2315 INT(10),
time20110506_2330 INT(10),
time20110506_2345 INT(10),
time20110507_0000 INT(10),
time20110507_0015 INT(10),
time20110507_0030 INT(10),
time20110507_0045 INT(10),
time20110507_0100 INT(10),
time20110507_0115 INT(10),
time20110507_0130 INT(10),
time20110507_0145 INT(10),
time20110507_0200 INT(10),
time20110507_0215 INT(10),
time20110507_0230 INT(10),
time20110507_0245 INT(10),
time20110507_0300 INT(10),
time20110507_0315 INT(10),
time20110507_0330 INT(10),
time20110507_0345 INT(10),
time20110507_0400 INT(10),
time20110507_0415 INT(10),
time20110507_0430 INT(10),
time20110507_0445 INT(10),
time20110507_0500 INT(10),
time20110507_0515 INT(10),
time20110507_0530 INT(10),
time20110507_0545 INT(10),
time20110507_0600 INT(10),
time20110507_0615 INT(10),
time20110507_0630 INT(10),
time20110507_0645 INT(10),
time20110507_0700 INT(10),
time20110507_0715 INT(10),
time20110507_0730 INT(10),
time20110507_0745 INT(10),
time20110507_0800 INT(10),
time20110507_0815 INT(10),
time20110507_0830 INT(10),
time20110507_0845 INT(10),
time20110507_0900 INT(10),
time20110507_0915 INT(10),
time20110507_0930 INT(10),
time20110507_0945 INT(10),
time20110507_1000 INT(10),
time20110507_1015 INT(10),
time20110507_1030 INT(10),
time20110507_1045 INT(10),
time20110507_1100 INT(10),
time20110507_1115 INT(10),
time20110507_1130 INT(10),
time20110507_1145 INT(10),
time20110507_1200 INT(10),
time20110507_1215 INT(10),
time20110507_1230 INT(10),
time20110507_1245 INT(10),
time20110507_1300 INT(10),
time20110507_1315 INT(10),
time20110507_1330 INT(10),
time20110507_1345 INT(10),
time20110507_1400 INT(10),
time20110507_1415 INT(10),
time20110507_1430 INT(10),
time20110507_1445 INT(10),
time20110507_1500 INT(10),
time20110507_1515 INT(10),
time20110507_1530 INT(10),
time20110507_1545 INT(10),
time20110507_1600 INT(10),
time20110507_1615 INT(10),
time20110507_1630 INT(10),
time20110507_1645 INT(10),
time20110507_1700 INT(10),
time20110507_1715 INT(10),
time20110507_1730 INT(10),
time20110507_1745 INT(10),
time20110507_1800 INT(10),
time20110507_1815 INT(10),
time20110507_1830 INT(10),
time20110507_1845 INT(10),
time20110507_1900 INT(10),
time20110507_1915 INT(10),
time20110507_1930 INT(10),
time20110507_1945 INT(10),
time20110507_2000 INT(10),
time20110507_2015 INT(10),
time20110507_2030 INT(10),
time20110507_2045 INT(10),
time20110507_2100 INT(10),
time20110507_2115 INT(10),
time20110507_2130 INT(10),
time20110507_2145 INT(10),
time20110507_2200 INT(10),
time20110507_2215 INT(10),
time20110507_2230 INT(10),
time20110507_2245 INT(10),
time20110507_2300 INT(10),
time20110507_2315 INT(10),
time20110507_2330 INT(10),
time20110507_2345 INT(10),

	
	time20110508_0000 INT(10),
time20110508_0015 INT(10),
time20110508_0030 INT(10),
time20110508_0045 INT(10),
time20110508_0100 INT(10),
time20110508_0115 INT(10),
time20110508_0130 INT(10),
time20110508_0145 INT(10),
time20110508_0200 INT(10),
time20110508_0215 INT(10),
time20110508_0230 INT(10),
time20110508_0245 INT(10),
time20110508_0300 INT(10),
time20110508_0315 INT(10),
time20110508_0330 INT(10),
time20110508_0345 INT(10),
time20110508_0400 INT(10),
time20110508_0415 INT(10),
time20110508_0430 INT(10),
time20110508_0445 INT(10),
time20110508_0500 INT(10),
time20110508_0515 INT(10),
time20110508_0530 INT(10),
time20110508_0545 INT(10),
time20110508_0600 INT(10),
time20110508_0615 INT(10),
time20110508_0630 INT(10),
time20110508_0645 INT(10),
time20110508_0700 INT(10),
time20110508_0715 INT(10),
time20110508_0730 INT(10),
time20110508_0745 INT(10),
time20110508_0800 INT(10),
time20110508_0815 INT(10),
time20110508_0830 INT(10),
time20110508_0845 INT(10),
time20110508_0900 INT(10),
time20110508_0915 INT(10),
time20110508_0930 INT(10),
time20110508_0945 INT(10),
time20110508_1000 INT(10),
time20110508_1015 INT(10),
time20110508_1030 INT(10),
time20110508_1045 INT(10),
time20110508_1100 INT(10),
time20110508_1115 INT(10),
time20110508_1130 INT(10),
time20110508_1145 INT(10),
time20110508_1200 INT(10),
time20110508_1215 INT(10),
time20110508_1230 INT(10),
time20110508_1245 INT(10),
time20110508_1300 INT(10),
time20110508_1315 INT(10),
time20110508_1330 INT(10),
time20110508_1345 INT(10),
time20110508_1400 INT(10),
time20110508_1415 INT(10),
time20110508_1430 INT(10),
time20110508_1445 INT(10),
time20110508_1500 INT(10),
time20110508_1515 INT(10),
time20110508_1530 INT(10),
time20110508_1545 INT(10),
time20110508_1600 INT(10),
time20110508_1615 INT(10),
time20110508_1630 INT(10),
time20110508_1645 INT(10),
time20110508_1700 INT(10),
time20110508_1715 INT(10),
time20110508_1730 INT(10),
time20110508_1745 INT(10),
time20110508_1800 INT(10),
time20110508_1815 INT(10),
time20110508_1830 INT(10),
time20110508_1845 INT(10),
time20110508_1900 INT(10),
time20110508_1915 INT(10),
time20110508_1930 INT(10),
time20110508_1945 INT(10),
time20110508_2000 INT(10),
time20110508_2015 INT(10),
time20110508_2030 INT(10),
time20110508_2045 INT(10),
time20110508_2100 INT(10),
time20110508_2115 INT(10),
time20110508_2130 INT(10),
time20110508_2145 INT(10),
time20110508_2200 INT(10),
time20110508_2215 INT(10),
time20110508_2230 INT(10),
time20110508_2245 INT(10),
time20110508_2300 INT(10),
time20110508_2315 INT(10),
time20110508_2330 INT(10),
time20110508_2345 INT(10),
time20110509_0000 INT(10),
time20110509_0015 INT(10),
time20110509_0030 INT(10),
time20110509_0045 INT(10),
time20110509_0100 INT(10),
time20110509_0115 INT(10),
time20110509_0130 INT(10),
time20110509_0145 INT(10),
time20110509_0200 INT(10),
time20110509_0215 INT(10),
time20110509_0230 INT(10),
time20110509_0245 INT(10),
time20110509_0300 INT(10),
time20110509_0315 INT(10),
time20110509_0330 INT(10),
time20110509_0345 INT(10),
time20110509_0400 INT(10),
time20110509_0415 INT(10),
time20110509_0430 INT(10),
time20110509_0445 INT(10),
time20110509_0500 INT(10),
time20110509_0515 INT(10),
time20110509_0530 INT(10),
time20110509_0545 INT(10),
time20110509_0600 INT(10),
time20110509_0615 INT(10),
time20110509_0630 INT(10),
time20110509_0645 INT(10),
time20110509_0700 INT(10),
time20110509_0715 INT(10),
time20110509_0730 INT(10),
time20110509_0745 INT(10),
time20110509_0800 INT(10),
time20110509_0815 INT(10),
time20110509_0830 INT(10),
time20110509_0845 INT(10),
time20110509_0900 INT(10),
time20110509_0915 INT(10),
time20110509_0930 INT(10),
time20110509_0945 INT(10),
time20110509_1000 INT(10),
time20110509_1015 INT(10),
time20110509_1030 INT(10),
time20110509_1045 INT(10),
time20110509_1100 INT(10),
time20110509_1115 INT(10),
time20110509_1130 INT(10),
time20110509_1145 INT(10),
time20110509_1200 INT(10),
time20110509_1215 INT(10),
time20110509_1230 INT(10),
time20110509_1245 INT(10),
time20110509_1300 INT(10),
time20110509_1315 INT(10),
time20110509_1330 INT(10),
time20110509_1345 INT(10),
time20110509_1400 INT(10),
time20110509_1415 INT(10),
time20110509_1430 INT(10),
time20110509_1445 INT(10),
time20110509_1500 INT(10),
time20110509_1515 INT(10),
time20110509_1530 INT(10),
time20110509_1545 INT(10),
time20110509_1600 INT(10),
time20110509_1615 INT(10),
time20110509_1630 INT(10),
time20110509_1645 INT(10),
time20110509_1700 INT(10),
time20110509_1715 INT(10),
time20110509_1730 INT(10),
time20110509_1745 INT(10),
time20110509_1800 INT(10),
time20110509_1815 INT(10),
time20110509_1830 INT(10),
time20110509_1845 INT(10),
time20110509_1900 INT(10),
time20110509_1915 INT(10),
time20110509_1930 INT(10),
time20110509_1945 INT(10),
time20110509_2000 INT(10),
time20110509_2015 INT(10),
time20110509_2030 INT(10),
time20110509_2045 INT(10),
time20110509_2100 INT(10),
time20110509_2115 INT(10),
time20110509_2130 INT(10),
time20110509_2145 INT(10),
time20110509_2200 INT(10),
time20110509_2215 INT(10),
time20110509_2230 INT(10),
time20110509_2245 INT(10),
time20110509_2300 INT(10),
time20110509_2315 INT(10),
time20110509_2330 INT(10),
time20110509_2345 INT(10)


);

INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
INSERT INTO parkingspaces (char_handicap) VALUES (0);
