package com.tup.buensabor;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.enums.FormaPago;
import com.tup.buensabor.enums.Role;
import com.tup.buensabor.enums.TipoEnvio;
import com.tup.buensabor.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class BuensaborApplication {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	CategoriaArticuloRepository categoriaArticuloRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;
    @Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	DetalleProductoRepository detalleProductoRepository;
	@Autowired
	ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	LocalidadRepository localidadRepository;
	@Autowired
	UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public BuensaborApplication(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(
				BuensaborApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			System.out.println("Funciona!");


		BigDecimal decimal = new BigDecimal("5443.00");
		BigDecimal decimal1 = new BigDecimal("10");
		BigDecimal decimal2 = new BigDecimal("5");
		BigDecimal decimal3 = new BigDecimal("10000");


		Date date = new Date();
		Usuario usuario = Usuario.builder()
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.auth0Id("1")
				.username("ElDiego")
				.password("123456")
				.build();


		Cliente cliente = Cliente.builder()
				.email("Diegote@gmail.com")
				.apellido("Maradona")
				.nombre("Diego")
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.telefono("2613612107")
				.build();

		ArticuloInsumo articuloInsumo = ArticuloInsumo.builder()
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.denominacion("Denominacion")
				.urlImagen("https://brandemia.org/contenido/subidas/2022/02/000-river-plate.jpg")
				.precioCompra(decimal)
				.stockActual(decimal1)
				.stockMinimo(decimal2)
				.build();

		//Cargo un par de productos para no cargarlos cada vez
		Producto producto = Producto.builder()
				.costo(decimal1)
				.precioVenta(decimal3)
				.tiempoEstimadoCocina(45)
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.urlImagen("https://cache-backend-mcd.mcdonaldscupones.com/media/image/product$ksX5rs2H/200/200/original?country=ar")
				.descripcion("Inigualable pan con semillas de sésamo, tres medallones de carne 100% vacuna, tres fetas de nuestro exclusivo Queso Cheddar, cebolla, lechuga y tomate frescos. Sumado a estos ingredientes la única e inigualable Salsa Tasty")
				.denominacion("Grand Tasty Turbo Bacon Triple").
				build();
			Producto producto1 = Producto.builder()
					.costo(decimal1)
					.precioVenta(decimal3)
					.tiempoEstimadoCocina(45)
					.fechaAlta(date)
					.fechaBaja(date)
					.fechaModificacion(date)
					.urlImagen("https://cache-backend-mcd.mcdonaldscupones.com/media/image/product$kqX3vl0y/200/200/original?country=ar")
					.descripcion("Quizás sean las dos hamburguesas de carne 100% vacuna con esa salsa especial y queso derretido, el toque de cebolla y la frescura de la lechuga o el crocante del pepino, lo que la hace la hamburguesa más famosa del mundo. Un sabor único.")
					.denominacion("Big Mac").
					build();
			Producto producto2= Producto.builder()
					.costo(decimal1)
					.precioVenta(decimal3)
					.tiempoEstimadoCocina(45)
					.fechaAlta(date)
					.fechaBaja(date)
					.fechaModificacion(date)
					.urlImagen("https://cache-backend-mcd.mcdonaldscupones.com/media/image/product$krXm2g5T/200/200/original?country=ar")
					.denominacion("Doble Carne Doble Queso")
					.descripcion("Hamburguesa elaborada con dos medallones de carne 100% de carne vacuna y dos fetas de nuestro exclusivo Queso Cheddar.")
					.build();
			Producto producto3 = Producto.builder()
					.costo(decimal1)
					.precioVenta(decimal3)
					.tiempoEstimadoCocina(45)
					.fechaAlta(date)
					.fechaBaja(date)
					.fechaModificacion(date)
					.urlImagen("https://cache-backend-mcd.mcdonaldscupones.com/media/image/product$kqXsCqnz/200/200/original?country=ar")
					.descripcion("Tres medallones de carne 100% vacuna, queso derretido, mostaza, kétchup y cebolla triturada, es algo que nunca puede fallar.")
					.denominacion("Triple Hamburguesa con Queso")
					.build();
			Producto producto4 = Producto.builder()
					.costo(decimal1)
					.precioVenta(decimal3)
					.tiempoEstimadoCocina(45)
					.fechaAlta(date)
					.fechaBaja(date)
					.fechaModificacion(date)
					.urlImagen("https://cache-backend-mcd.mcdonaldscupones.com/media/image/product$kqXt7Sq2/200/200/original?country=ar")
					.descripcion("maginá la sensación del clásico Cuarto de Libra. Imaginalo con un medallón de deliciosa carne 100% vacuna, queso cheddar, cebolla, kétchup y mostaza ¿Listo? Ahora duplicá esa sensación. Ya tenés el Doble Cuarto en la cabeza.")
					.denominacion("Doble Cuarto de Libra con Queso")
					.build();
			Producto producto5 = Producto.builder()
					.costo(decimal1)
					.precioVenta(decimal3)
					.tiempoEstimadoCocina(45)
					.fechaAlta(date)
					.fechaBaja(date)
					.fechaModificacion(date)
					.urlImagen("https://cache-backend-mcd.mcdonaldscupones.com/media/image/product$kQX3BMhy/200/200/original?country=ar")
					.descripcion("Tres carnes, inigualable queso cheddar, cebolla, kétchup y mostaza, y el increíble ingrediente que lo hace único: bacon premium.")
					.denominacion("Grand Triple McBacon")
					.build();




			DetalleProducto detalleProducto = DetalleProducto.builder()
				.cantidad(decimal2)
				.build();

		DetalleFactura detalleFactura = DetalleFactura.builder()
				.cantidad(48)
				.subtotal(decimal1)
				.build();
		DetallePedido detallePedido = DetallePedido.builder()
				.cantidad(45)
				.subtotal(decimal)
				.subtotalCosto(decimal3)
				.build();

		Localidad localidad= Localidad.builder()
					.codigoPostal(5521)
					.nombre("Guaymallén")
					.build();

		Domicilio domicilio = Domicilio.builder()
				.calle("Los Reyunos")
				.numero(4517)
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.numeroDpto(27)
				.pisoDpto(3)
				.build();


		Factura factura = Factura.builder()
				.formaPago(FormaPago.MERCADO_PAGO)
				.totalVenta(decimal3).fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.fechaFacturacion(date)
				.mpPreferenceId("prerenceID")
				.mpPaymentType("pmt")
				.mpMerchantOrderId(7981)
				.mpPaymentId(7848)
				.build();
		Factura factura1=Factura.builder()
				.formaPago(FormaPago.MERCADO_PAGO)
				.totalVenta(decimal3).fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.fechaFacturacion(date)
				.mpPreferenceId("prerenceID")
				.mpPaymentType("pmt")
				.mpMerchantOrderId(7981)
				.mpPaymentId(7848)
				.build();

		Pedido pedido = Pedido.builder()
				.total(decimal1)
				.totalCosto(decimal2)
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.fechaPedido(date)
				.estado(EstadoPedido.COMPLETADO)
				.formaPago(FormaPago.MERCADO_PAGO)
				.tipoEnvio(TipoEnvio.DELIVERY)
				.horaEstimadaFinalizacion(date)
				.build();

			Pedido pedido1 = Pedido.builder()
					.total(decimal1)
					.totalCosto(decimal2)
					.fechaAlta(date)
					.fechaBaja(date)
					.fechaModificacion(date)
					.fechaPedido(date)
					.estado(EstadoPedido.COMPLETADO)
					.formaPago(FormaPago.MERCADO_PAGO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.horaEstimadaFinalizacion(date)
					.build();


			UnidadMedida unidadMedida = UnidadMedida.builder()
				.abreviatura("KG")
				.denominacion("Masa")
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.build();
		CategoriaArticulo categoriaArticulo = CategoriaArticulo.builder()
				.denominacion("Carne")
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.build();

		//creacion del admin
			User admin = User.builder()
					.username("Admin")
					.password(passwordEncoder.encode("admin"))
					.role(Role.ADMIN)
					.build();

			userRepository.save(admin);

			articuloInsumo.setCategoriaArticulo(categoriaArticulo);
			cliente.setUsuario(usuario);
			pedido.setCliente(cliente);
			pedido.setDomicilioEntrega(domicilio);
			factura.setPedido(pedido);
			factura1.setPedido(pedido1);
			domicilio.setCliente(cliente);
			localidad.agregardomicilio(domicilio);
			detallePedido.setPedido(pedido);
			detallePedido.setProducto(producto);
			detallePedido.setArticuloInsumo(articuloInsumo);
			detalleProducto.setArticuloInsumo(articuloInsumo);
			detalleProducto.setArticuloManufacturado(producto);
			detalleFactura.setProducto(producto);
			detalleFactura.setArticuloInsumo(articuloInsumo);
			detalleFactura.setFactura(factura);
			detalleFactura.setFactura(factura1);
			articuloInsumo.setUnidadMedida(unidadMedida);
			unidadMedidaRepository.save(unidadMedida);
			categoriaArticuloRepository.save(categoriaArticulo);
			articuloInsumoRepository.save(articuloInsumo);
			usuarioRepository.save(usuario);
			clienteRepository.save(cliente);
			localidadRepository.save(localidad);
			domicilioRepository.save(domicilio);
			pedidoRepository.save(pedido);
			pedidoRepository.save(pedido1);
			facturaRepository.save(factura);
			productoRepository.save(producto);
			productoRepository.save(producto1);
			productoRepository.save(producto2);
			productoRepository.save(producto3);
			productoRepository.save(producto4);
			productoRepository.save(producto5);
			detallePedidoRepository.save(detallePedido);
			facturaRepository.save(factura1);
			detalleFacturaRepository.save(detalleFactura);
			detalleProductoRepository.save(detalleProducto);







			};
		}



	}
