--Drop all db objects in order

DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS bug_list;


CREATE TABLE bug_list (
    bug_list_id SERIAL,
    name varchar(50) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT PK_bug_list PRIMARY KEY (bug_list_id)
);

CREATE TABLE ticket (
    ticket_id SERIAL,
    bug_list_id INT NOT NULL,
    title varchar(100) NOT NULL,
    description TEXT,
    status varchar(20) NOT NULL,
    assigned_to varchar(100),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT PK_ticket PRIMARY KEY (ticket_id),
    CONSTRAINT FK_ticket_bug_list FOREIGN KEY (bug_list_id) REFERENCES bug_list(bug_list_id);
)



