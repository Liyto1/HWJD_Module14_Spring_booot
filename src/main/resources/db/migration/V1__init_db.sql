CREATE TABLE note (
    id UUID DEFAULT random_uuid() PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title VARCHAR(250) NOT NULL CHECK(LENGTH(title) >= 3 AND LENGTH(title) <= 250),
    content VARCHAR NOT NULL,
    last_updated_date DATE NOT NULL,
    created_date DATE NOT NULL
);