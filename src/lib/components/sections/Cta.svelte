<script>
    import Icon from "@iconify/svelte";
</script>
<section class="bg-black">
    <div class="max-w-6xl mx-auto grid md:grid-cols-2 gap-12 p-4 items-center">
        <div class="">
            <h2 class="font-semibold text-4xl text-white p-2">You do the business, <br>we'll handle the money.</h2>
            <p class="text-gray-400 p-4">With the right credit card, you can improve your financial life by <br>building credit, earning rewards and saving money. But with <br>hundreds of credit cards in the market.</p>
            <button class="bg-cyan-400 p-4 rounded-lg text-2xl"><a href="/">Get Started</a></button>
        </div>
        <div class="bg-black text-white p-8 space-y-6 max-w-md mx-auto">
            <!-- Rewards Section -->
            <div class="flex items-start space-x-4 hover:bg-gray-800 cursor-pointer rounded-lg">
              <div class="bg-gray-400 p-2 rounded-full">
                <Icon icon="mdi:star" class="text-cyan-400 text-xl" />
              </div>
              <div>
                <h2 class="font-bold text-lg">Rewards</h2>
                <p class="text-sm">The best credit cards offer some tantalizing combinations of promotions and prizes.</p>
              </div>
            </div>
          
            <!-- 100% Secured Section -->
            <div class="flex items-start space-x-4 hover:bg-gray-800 cursor-pointer rounded-lg">
              <div class="bg-teal-500 p-2 rounded-full">
                <Icon icon="mdi:shield-check" class="text-white text-xl" />
              </div>
              <div class="hover:bg-gray-800 p-4 rounded-lg">
                <h2 class="font-bold text-lg">100% Secured</h2>
                <p class="text-sm">We take proactive steps to make sure your information and transactions are secure.</p>
              </div>
            </div>
          
            <!-- Balance Transfer Section -->
            <div class="flex items-start space-x-4 hover:bg-gray-800 cursor-pointer rounded-lg">
              <div class="bg-cyan-400 p-2 rounded-full">
                <Icon icon="lets-icons:send-fill" class="text-white text-xl"/>  
              </div>
              <div>
                <h2 class="font-bold text-lg">Balance Transfer</h2>
                <p class="text-sm">A balance transfer credit card can save you a lot of money in interest charges.</p>
              </div>
            </div>
          </div>
    </div>

</section>