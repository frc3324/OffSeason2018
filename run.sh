sudo apt-get update -y
sudo apt-get install clang-format-5.0 -y
chmod +x ./format.sh
./format.sh src/
