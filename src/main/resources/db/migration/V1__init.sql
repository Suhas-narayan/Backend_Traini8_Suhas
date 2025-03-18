CREATE TABLE IF NOT EXISTS training_centers (
    id BIGSERIAL PRIMARY KEY,
    center_name VARCHAR(40) NOT NULL,
    center_code VARCHAR(12) NOT NULL UNIQUE,
    detailed_address TEXT NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    pincode VARCHAR(6) NOT NULL,
    student_capacity INTEGER,
    created_on TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    contact_email VARCHAR(255),
    contact_phone VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS courses_offered (
    id BIGSERIAL PRIMARY KEY,
    training_center_id BIGINT NOT NULL,
    course VARCHAR(255) NOT NULL,
    CONSTRAINT fk_training_center
        FOREIGN KEY (training_center_id)
        REFERENCES training_centers (id)
        ON DELETE CASCADE
);

CREATE INDEX idx_training_center_code ON training_centers(center_code);
CREATE INDEX idx_training_center_city ON training_centers(city);
CREATE INDEX idx_training_center_state ON training_centers(state);