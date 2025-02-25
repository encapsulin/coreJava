while true; do
python3 screen.py
fn="screen-$(date +%Y%m%d_%H%M%S).png"
echo $fn
mv ./screen.png ./screen/$fn
sleep 5
done