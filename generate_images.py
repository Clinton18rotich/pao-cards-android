import os
import time
import socket
import urllib.parse
import urllib.request

# Force 30-second timeout on all socket operations
socket.setdefaulttimeout(30)

output_dir = "app/src/main/assets/people"
os.makedirs(output_dir, exist_ok=True)

# Import prompts from existing script
from generate_images_prompts import prompts

# Pollinations API Key
POLLINATIONS_KEY = "sk_xGUE3eg0qkCiSzwFLX3BZ3PgGluZ740C"

def fetch_image(card_id, prompt, max_attempts=3):
    filepath = os.path.join(output_dir, f"{card_id}.jpg")
    if os.path.exists(filepath) and os.path.getsize(filepath) > 1000:
        return True
    
    encoded = urllib.parse.quote(prompt)
    url = f"https://image.pollinations.ai/prompt/{encoded}?width=512&height=768&nologo=true&seed={int(time.time())}"
    
    for attempt in range(1, max_attempts + 1):
        try:
            print(f"  [{card_id}] attempt {attempt}...", end=" ", flush=True)
            
            # Create request with Authorization header
            req = urllib.request.Request(url)
            req.add_header("Authorization", f"Bearer {POLLINATIONS_KEY}")
            
            with urllib.request.urlopen(req, timeout=45) as response:
                with open(filepath, 'wb') as out_file:
                    out_file.write(response.read())
                    
            if os.path.getsize(filepath) < 1000:
                os.remove(filepath)
                print("too small")
                continue
            print("✅")
            return True
            
        except socket.gaierror as e:
            print(f"DNS error ({e})")
            time.sleep(5)
        except urllib.error.HTTPError as e:
            if e.code == 402:
                print("HTTP 402 (Waiting 60s)")
                time.sleep(60)
            else:
                print(f"HTTP {e.code}")
                time.sleep(10)
        except Exception as e:
            print(f"error: {e}")
            time.sleep(5)
    return False

while True:
    todo = [cid for cid in prompts if not (os.path.exists(os.path.join(output_dir, f"{cid}.jpg")) and os.path.getsize(os.path.join(output_dir, f"{cid}.jpg")) > 1000)]
    
    if not todo:
        print("🎉 All 39 images generated!")
        break
    
    print(f"\n=== {len(todo)} remaining: {todo} ===")
    
    for card_id in todo:
        fetch_image(card_id, prompts[card_id])
        time.sleep(46)  # Rate limit only between SUCCESSFUL attempts
    
    # Count what's done now
    done = sum(1 for f in os.listdir(output_dir) if f.endswith('.jpg'))
    print(f"\nProgress: {done}/39 images")
    
    if done == 39:
        print("🎉 All 39 images generated!")
        break
    
    print("Waiting 120s before next pass...")
    time.sleep(120)
