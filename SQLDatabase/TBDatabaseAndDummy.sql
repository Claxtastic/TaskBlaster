
-- Drop Tables

DROP TABLE IF EXISTS ProjectMembers;
DROP TABLE IF EXISTS Task;
DROP TABLE IF EXISTS Project;
DROP TABLE IF EXISTS UserData;

-- Create Tables

CREATE TABLE ProjectMembers (
	ProjectID	INTEGER NOT NULL,
	UserID	INTEGER NOT NULL,
	FOREIGN KEY(ProjectID) REFERENCES Project(ProjectID) ON DELETE CASCADE,
	FOREIGN KEY(UserID) REFERENCES UserData(UserID) ON DELETE CASCADE
);
CREATE TABLE Task (
	TaskID	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	TaskName	VARCHAR(255) NOT NULL,
	ProjectID	INTEGER NOT NULL,
	UserID	INTEGER,
	DateCreated	DATE NOT NULL,
	DateCompleted	DATE,
	PointsWorth	INTEGER DEFAULT 0,
	FOREIGN KEY(UserID) REFERENCES UserData(UserID) ON DELETE SET NULL,
	FOREIGN KEY(ProjectID) REFERENCES Project(ProjectID) ON DELETE CASCADE
);
CREATE TABLE Project (
	ProjectID	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	ProjectName	VARCHAR(255) NOT NULL
);
--Note: Apparently User and Password are reserved words in SQL. Who knew
CREATE TABLE UserData (
	UserID	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	Username	VARCHAR(20) NOT NULL UNIQUE,
	LastName	VARCHAR(35),
	FirstName	VARCHAR(35),
	UserPassword	VARCHAR(255) NOT NULL,
	Privilege	CHAR(7) NOT NULL DEFAULT 'Student',
	Points	INTEGER DEFAULT 0
);

-- Populate Tables

--Dummy Projects
INSERT INTO Project (ProjectName) VALUES 
	('Space Ballz');
INSERT INTO Project (ProjectName) VALUES 
	('Financial Bookkeeping');
	
--Dummy Users
INSERT INTO UserData (Username, LastName, FirstName, UserPassword, Privilege) VALUES 
	('Admin', 'OP', 'Anon', 'allThePriveleges', 'Admin');
INSERT INTO UserData (Username, LastName, FirstName, UserPassword, Privilege) VALUES 
	('jsmith42', 'Smith', 'John', 'badPasswordLol', 'Student');
INSERT INTO UserData (Username, LastName, FirstName, UserPassword, Privilege) VALUES 
	('eCollins', 'Collins', 'Elizabeth', 'Password2Good?', 'Faculty');
INSERT INTO UserData (Username, LastName, FirstName, UserPassword) VALUES 
	('jdoe', 'Doe', 'Jane', 'tasukete');
	
--Add user to Project (table ProjectMembers)
--Format(PID,UID): Add to project project <PID> user <UID>
INSERT INTO ProjectMembers (ProjectID, UserID) VALUES 
	((SELECT ProjectID FROM Project WHERE ProjectName = 'Space Ballz'), (SELECT UserID FROM UserData WHERE UserID = '1'));
--Technical 'right' way to do it for foreign keys ^^^^^. For rest I'll use lazy IDs for time save
INSERT INTO ProjectMembers (ProjectID, UserID) VALUES 
	('2', '1');
INSERT INTO ProjectMembers (ProjectID, UserID) VALUES 
	('1', '3');
INSERT INTO ProjectMembers (ProjectID, UserID) VALUES 
	('2', '3');
INSERT INTO ProjectMembers (ProjectID, UserID) VALUES 
	('2', '2');
INSERT INTO ProjectMembers (ProjectID, UserID) VALUES 
	('2', '4');
	
--Add tasks to project
--In class we learned you have to add DATE before a date, but for some reason it doesn't like it anymore *shrug*
INSERT INTO Task (TaskName, ProjectID, UserID, DateCreated, PointsWorth) VALUES 
	('UI Purchase', '2', '4', '2020-01-15', '23');
INSERT INTO Task (TaskName, ProjectID, UserID, DateCreated, DateCompleted, PointsWorth) VALUES 
	('UI Baggage', '2', '4', '2020-01-18', '2020-01-19', '14');
INSERT INTO Task (TaskName, ProjectID, UserID, DateCreated, PointsWorth) VALUES 
	('Backend Shenanigans', '2', '2', '2020-04-05', '89');
INSERT INTO Task (TaskName, ProjectID, UserID, DateCreated, DateCompleted, PointsWorth) VALUES 
	('Playable Demo', '1', '3', '2019-12-26', '2020-02-11', '1000');
INSERT INTO Task (TaskName, ProjectID, UserID, DateCreated, DateCompleted, PointsWorth) VALUES 
	('Tutorial', '2', '3', '2020-03-19', '2020-04-23', '750');
	
--COMMIT;

-- Display Tables

SELECT * FROM Project;
SELECT * FROM UserData;
SELECT * FROM ProjectMembers;
SELECT * FROM Task;

-- Sample Combo Display
SELECT ProjectName, Username
	FROM (Project INNER JOIN ProjectMembers ON Project.ProjectID= ProjectMembers.ProjectID) P
		INNER JOIN UserData U ON P.UserID=U.UserID
	ORDER BY P.ProjectName;
	
SELECT U.UserID, Username, SUM(PointsWorth)
	FROM UserData U INNER JOIN Task T on U.UserID=T.UserID
	WHERE T.DateCompleted IS NOT NULL
	GROUP BY U.UserID, Username
	ORDER BY U.UserID;