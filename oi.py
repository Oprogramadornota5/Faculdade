import requests
import pandas as pd
import matplotlib.pyplot as plt

# Coletar dados do servidor Java
response = requests.get("http://localhost:8000/data")
data = response.json()

# Criar DataFrame
df = pd.DataFrame([data])

# Analisar e visualizar dados
plt.plot(df['value'])
plt.title('Sensor Data')
plt.xlabel('Time')
plt.ylabel('Value')
plt.show()
