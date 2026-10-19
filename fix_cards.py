import re

path = 'app/src/main/java/com/example/paocards/data/CardData.kt'
with open(path, 'r') as f:
    content = f.read()

# 1. Fix Ronaldo: "Kicking", "a soccer ball" -> "Striking", "a free-kick wall"
content = content.replace(
    '"Cristiano Ronaldo", "Kicking", "a soccer ball"',
    '"Cristiano Ronaldo", "Striking", "a free-kick wall"'
)

# 2. Fix Tom Brady: "Throwing", "a football" -> "Spiraling", "a pigskin"
content = content.replace(
    '"Tom Brady", "Throwing", "a football"',
    '"Tom Brady", "Spiraling", "a pigskin"'
)

# 3. Fix Kimutete: "Kicking", "a soccer ball" -> "Kicking", "a rugby ball"
content = content.replace(
    '"Kimutete", "Kicking", "a soccer ball"',
    '"Kimutete", "Kicking", "a rugby ball"'
)

# 4. Fix Julius Caesar: "Stabbing", "a toga pin" -> "Betraying", "a toga pin"
content = content.replace(
    '"Julius Caesar", "Stabbing", "a toga pin"',
    '"Julius Caesar", "Betraying", "a toga pin"'
)

with open(path, 'w') as f:
    f.write(content)

print("✅ Card fixes applied!")
