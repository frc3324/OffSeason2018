sudo apt-get update -y
sudo apt-get install clang-format-5.0 -y
find ./src/ -iname *.java | xargs clang-format -i
