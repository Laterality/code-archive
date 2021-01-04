package main

import (
	"fmt"
	"os"
)

func main() {
	envVars := os.Environ()

	for _, keyValue := range envVars {
		fmt.Println(keyValue)
	}
}
