CREATE SEQUENCE public.proveedor_id_proveedor_seq_1;

CREATE TABLE public.Proveedor (
                id_proveedor INTEGER NOT NULL DEFAULT nextval('public.proveedor_id_proveedor_seq_1'),
                nombre VARCHAR NOT NULL,
                RUC INTEGER NOT NULL,
                telefono INTEGER NOT NULL,
                CONSTRAINT proveedor_pk PRIMARY KEY (id_proveedor)
);


ALTER SEQUENCE public.proveedor_id_proveedor_seq_1 OWNED BY public.Proveedor.id_proveedor;

CREATE SEQUENCE public.producto_id_producto_seq;

CREATE TABLE public.Producto (
                id_producto INTEGER NOT NULL DEFAULT nextval('public.producto_id_producto_seq'),
                id_proveedor INTEGER NOT NULL,
                nombre VARCHAR NOT NULL,
                precio INTEGER NOT NULL,
                descripcion VARCHAR,
                stock INTEGER NOT NULL,
                favorito BOOLEAN NOT NULL,
                CONSTRAINT producto_pk PRIMARY KEY (id_producto)
);


ALTER SEQUENCE public.producto_id_producto_seq OWNED BY public.Producto.id_producto;

ALTER TABLE public.Producto ADD CONSTRAINT proveedor_producto_fk
FOREIGN KEY (id_proveedor)
REFERENCES public.Proveedor (id_proveedor)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

--select * from proveedor;
--select * from producto;

alter table producto add column url varchar;




insert into proveedor (nombre, ruc, telefono)
values ('Polo', 123456, 0987456123),
('Zara', 456789, 0981369258),
('Gucci', 789123, 0982147258),
('Louis Vuitton', 147258, 0961145236),
('Lacoste', 369852, 0985896523);


insert into producto (id_proveedor, nombre, precio, descripcion, stock, favorito, url)
values (1,'Vestido Tami Love Noir', 120000, 'Tamaños disponibles en: S, M, L. Colores disponibles: Negro, Rojo, Rosa.', 25, true, 'https://images-na.ssl-images-amazon.com/images/I/61bU4ViU5%2BL._AC_SL1001_.jpg'),
(1, 'Vestido Coconut Palm', 150000, 'Tamaños disponibles en: S, M. Colores disponibles: Blanco.', 30, true, 'https://9eba410b89d8c2b814f2-f653ee9e3b6aad4b2107b6a1ab482f61.ssl.cf2.rackcdn.com/product-hugerect-940908-112265-1490004508-136be288ddcfe9030a8632f9ffcdb003.jpg'),
(2, 'Vestido Midi Blue Garden', 110000, 'Tamaños disponibles en: S, M. Colores disponibles: Modelo unico.', 12, false, 'https://www.dhresource.com/0x0/f2/albu/g7/M01/8D/75/rBVaSVsJHnqAMFT9AAJe_JkKqPA101.jpg'),
(3, 'Vestido Pía Black Garden', 170000, 'Tamaños disponibles en: XS, S. Colores disponibles: Modelo unico.', 5, false, 'https://vestidosyzapatos.es/wp-content/uploads/2018/06/vestidos-de-fiesta-backless-dress-vestido-espalda-abierta-vestido-largo-verano-2018-vestidos-baratos-online-descuento-ropa-barata-online-vestidosyzapatos.es-flores-azul-2.jpg'),
(3, 'Vestido Bohemios Vintage', 215000, 'Tamaños disponibles en: XS, M , L. Colores disponibles: Modelo unico.', 23, true, 'https://ae01.alicdn.com/kf/HTB1JBGgaITxK1Rjy0Fgq6yovpXaU/Vestido-bohemios-largos-con-estampado-Floral-para-mujer-Vestido-bohemio-de-verano-para-la-playa-Vestido.jpg_q50.jpg'),
(4, 'Vestido Conce', 190000, 'Tamaños disponibles en: XS, S, M. Colores disponibles: Azul y estampados.', 147, true, 'https://cdn.shopify.com/s/files/1/0062/7500/6515/products/product-image-896651839.jpg'),
(4, 'Vestido Atenea Mix', 105000, 'Tamaños disponibles en: M, L. Colores disponibles: Rosa y Celeste.', 63, false, 'https://pipiluxury.com/wp-content/uploads/2020/05/NEDEINS-Women-V-Neck-Split-Dress-Floral-Print-Long-Summer-Spaghetti-Strap-Party-Pink-Chiffon-Elegant-3.jpg'),
(5, 'Vestido Louise Petróleo', 155000, 'Tamaños disponibles en: XS, S, M. Colores disponibles: Modelo Unico.', 34, true, 'https://i.etsystatic.com/18236162/r/il/201b8b/1628087393/il_794xN.1628087393_mjjw.jpg');


(3, 'Vestido Passion Moon', 130000, 'Tamaños disponibles en: XS, S. Colores disponibles: Rojo y Rosa.', 8, true),
(4, 'Vestido Spring Evergarden', 145000, 'Tamaños disponibles en: XS, S, M. Colores disponibles: Modelo unico.', 17, false),
(5, 'Vestido Cream Drops', 165000, 'Tamaños disponibles en: XS, S, M, L. Colores disponibles: Rosa y Celeste.', 8, true),
(2, 'Vestido Lapizlazuli Drops', 225000, 'Tamaños disponibles en: XS, S, M, L. Colores disponibles: Esmeralda y Celeste.', 21, true),
(2, 'Vestido Pearl Snow White', 165000, 'Tamaños disponibles en: XS, M. Colores disponibles: Modelo unico.', 13, false),
(1, 'Vestido Gabana Stripes', 230000, 'Tamaños disponibles en: S. Colores disponibles: Modelo unico.', 7, false),
(5, 'Vestido Laced Palms', 350000, 'Tamaños disponibles en: S, M. Colores disponibles: Modelo unico.', 6, false);