# 🧩 Yocto Matrix Build Setup (Generic)

This repository provides a **generic matrix-based Yocto build system** using `kas` and standard Poky-based layers. It supports multiple:

- **Build types**: `dev`, `test`, `prod`
- **Targets**: e.g., `qemu-arm64`, `qemu-x86`
- **Configurations**: layered via kas config overlays

---

## 📁 Directory Structure

```text
yocto-test-public/
├── kas/
│   └── default.yml                  # Base kas config
├── meta-custom/                    # Custom meta layer (images, distros)
│   ├── conf/distro/
│   └── recipes-core/images/
├── build-configs/
│   ├── target/                     # Target-specific overlays
│   └── build-type/                # Build-type overlays
```

---

## ⚙️ Requirements

- Linux (Ubuntu/Debian preferred)
- Git
- Python 3.8+
- Yocto build host dependencies

---

## 🛠️ System Preparation

### 🔹 Install Yocto Host Dependencies (Debian/Ubuntu)

```bash
sudo apt update
sudo apt install -y \
  gawk wget git diffstat unzip texinfo gcc build-essential \
  chrpath socat cpio python3 python3-pip python3-venv \
  xz-utils debianutils iputils-ping libsdl1.2-dev xterm
```

---

## 🐍 Set Up Python Virtual Environment (Recommended)

We’ll install `kas` in an isolated Python environment to avoid system conflicts.

```bash
# 1. Create a virtual environment
python3 -m venv ~/kas-env

# 2. Activate it
source ~/kas-env/bin/activate

# 3. Install kas inside the virtual env
pip install kas

# 4. Add kas to PATH (optional for convenience)
echo 'export PATH="$HOME/kas-env/bin:$PATH"' >> ~/.bashrc
source ~/.bashrc

# 5. Test kas
kas --version
```

---

## 🚀 Build Usage

### 🧪 Development Image for QEMU ARM64

```bash
kas build \
  kas/default.yml:build-configs/target/qemu-arm64.yml:build-configs/build-type/dev.yml
```

### 🔒 Production Image for QEMU x86

```bash
kas build \
  kas/default.yml:build-configs/target/qemu-x86.yml:build-configs/build-type/prod.yml
```

Each build is composed of:
- `default.yml`: base repo/layer config
- `target/*.yml`: hardware/machine info
- `build-type/*.yml`: image features and policy

---

## 🧪 Running Built Images (QEMU example)

```bash
runqemu qemuarm64 nographic
```

Look for the image files in:
```
build/tmp/deploy/images/qemuarm64/
```

---

## 📦 Layers Used

- [poky](https://git.yoctoproject.org/poky/)
- [meta-openembedded](https://git.openembedded.org/meta-openembedded/)
- `meta-custom/` (included locally)

---

## 🧩 Extend the Matrix

To add a new target:
- Create a new `build-configs/target/<newtarget>.yml`

To add a new build type:
- Create a new `build-configs/build-type/<newtype>.yml`
- Create `meta-custom/conf/distro/custom-<newtype>.conf`

---

## 💬 Support

For questions or improvements, file an issue or contact the project maintainer.
