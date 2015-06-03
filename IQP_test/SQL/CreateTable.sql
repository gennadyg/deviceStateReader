CREATE TABLE DeviceData
(
  `CustomerID` int(11) NOT NULL,
  `ClientTimestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `StreamID` varchar(1000) CHARACTER SET utf8 NOT NULL,
  `DataType` enum('Integer','String','Long','Float','Double','String','Unknown','Binary','JSON') COLLATE utf8_unicode_ci NOT NULL,
  `Units` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `Data` varchar(2048) CHARACTER SET utf8 DEFAULT NULL,
  `ServerTimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`CustomerID`,`ClientTimestamp`,`Units`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;