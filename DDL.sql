CREATE TABLE facility
(
    id INT NOT NULL,
    availablecapacity INT NOT NULL,
    details VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    inuse VARCHAR NOT NULL,
    downtime VARCHAR NOT NULL
);
CREATE TABLE inspection
(
    id INT PRIMARY KEY NOT NULL,
    details VARCHAR NOT NULL,
    usageid INT NOT NULL
);
CREATE TABLE maintenance
(
    id INT NOT NULL,
    facilityid INT NOT NULL,
    cost INT NOT NULL,
    startdate VARCHAR NOT NULL,
    enddate VARCHAR NOT NULL
);
CREATE TABLE owner
(
    id INT NOT NULL,
    name VARCHAR NOT NULL,
    facilityid INT NOT NULL
);
CREATE TABLE problem
(
    id INT NOT NULL,
    details VARCHAR NOT NULL,
    foundon VARCHAR NOT NULL,
    isresolved VARCHAR NOT NULL,
    resolvedon VARCHAR NOT NULL,
    maintenanceid INT NOT NULL
);
CREATE TABLE usage
(
    id INT NOT NULL,
    facilityid INT NOT NULL,
    startdate VARCHAR NOT NULL,
    enddate VARCHAR NOT NULL
);
