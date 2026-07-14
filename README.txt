# Llanquihue Tour App 🏔️🚌

Este proyecto es una aplicación de escritorio desarrollada en Java utilizando **IntelliJ IDEA**. Corresponde a la actividad sumativa de la Semana 8: *"Integrando interfaces, polimorfismo y estructuras dinámicas"*, enfocada en robustecer el sistema interno de la agencia de turismo **Llanquihue Tour**.

## 📋 Características Principales
- **Diseño Polimórfico:** Uso de interfaces para unificar comportamientos de distintas entidades.
- **Colecciones Dinámicas:** Almacenamiento flexible mediante `ArrayList` genéricos.
- **Validación en Tiempo de Ejecución:** Uso del operador `instanceof` para diferenciar tipos de objetos.
- **Interfaz Gráfica (GUI):** Menú interactivo vertical utilizando `JOptionPane`.
- **Robustez de Datos (Regex):** Validación estricta de formatos (patentes chilenas de 6 caracteres y nombres sin números).

---

## 📂 Estructura del Proyecto (Arquitectura Modular)

El código se organiza estrictamente bajo el patrón solicitado en tres paquetes principales dentro de `src/`:

```text
src/
├── model/
│   ├── Registrable.java      # Interfaz de comportamiento común (Contrato)
│   ├── GuiaTuristico.java    # Entidad de personal que implementa Registrable
│   └── Vehiculo.java         # Entidad de logística que implementa Registrable
├── data/
│   └── GestorEntidades.java  # Manejo del ArrayList polimórfico e instanceof
└── ui/
    └── MainFrame.java        # Menú principal y flujos de captura con GUI
```

---

## 🛠️ Reglas de Negocio Implementadas

1. **Contrato Único (`Registrable`):** Obliga a todas las entidades a implementar el método `mostrarResumen()`.
2. **Validación de Nombres:** El sistema prohíbe el uso de números o caracteres especiales en el nombre de los guías.
3. **Validación de Patentes:** Se valida mediante Expresiones Regulares (Regex) que la matrícula cumpla con el formato chileno exacto de 6 caracteres:
   - Formato Nuevo: 4 letras y 2 números (Ej: `BBBB12`).
   - Formato Antiguo: 2 letras y 4 números (Ej: `BB1234`).

---

## 🚀 Cómo Ejecutar el Proyecto Localmente

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/macagonzac-source/llanquihuetourapp-semana8]
   ```
2. **Abrir en IntelliJ IDEA:**
   - Selecciona `File` -> `Open...` y busca la carpeta raíz del proyecto clonado.
3. **Ejecutar la aplicación:**
   - Dirígete a `src/ui/MainFrame.java`.
   - Haz clic derecho sobre el archivo y selecciona **Run 'MainFrame.main()'**.

---

## 👤 Autor
- **Nombre:** Macarena González Concha
- **Asignatura:** Programación Orientada a Objetos
- **Institución:** DUOC UC
- **Semana:** Semana 8 - Actividad Sumativa Individual
