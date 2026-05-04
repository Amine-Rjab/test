import subprocess
import sqlite3

# Hardcoded secret
API_KEY = "123456-SECRET-KEY"

def run_command(user_input):
    
    subprocess.call("ls " + user_input, shell=True)

def login(username, password):
    conn = sqlite3.connect("users.db")
    cursor = conn.cursor()

    query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'"

    cursor.execute(query)

    return cursor.fetchone()


def insecure_eval(data):
    # Dangerous eval usage
    return eval(data)


if __name__ == "__main__":
    user_input = input("Enter command: ")
    run_command(user_input)