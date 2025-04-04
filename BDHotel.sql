Insert into usuarios(id_usuario, usuario_nombre, usuario_clave, usuario_estado)Values(0, 'Maudy','Maudy',1);

Select * from usuarios;

Delete from usuarios where id_usuario = 2;

Update usuarios set usuario_clave='maudy' where id_usuario=1;

CREATE TABLE habitaciones (
    id_habitacion INT AUTO_INCREMENT PRIMARY KEY,  -- ID único de la habitación
    numero_habitacion VARCHAR(10) NOT NULL,        -- Número de la habitación (por ejemplo, 101, 102)
    tipo_habitacion ENUM('sencilla', 'doble', 'suite') NOT NULL, -- Tipo de habitación
    precio_noche DECIMAL(10, 2) NOT NULL,          -- Precio por noche
    estado ENUM('disponible', 'ocupada', 'mantenimiento') DEFAULT 'disponible'  -- Estado de la habitación
);
ALTER TABLE reservas
ADD CONSTRAINT fk_huesped_id
FOREIGN KEY (id_huesped) REFERENCES huespedes(id_huesped)
ON DELETE CASCADE;
