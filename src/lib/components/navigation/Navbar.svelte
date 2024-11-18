<script>
	let isOpen = false; 

	function toggleMenu() {
		isOpen = !isOpen;
	}
</script>

<nav class="bg-[#11101d] shadow-lg fixed w-full z-50 mb-4">
	<div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
		<div class="flex justify-between items-center h-16">
			<!-- Logo -->
			<div class="flex-shrink-0">
				<a href="/" class="text-2xl font-bold text-white">
					MyLogo
				</a>
			</div>

			<!-- Desktop Menu -->
			<div class="hidden md:flex space-x-8">
				<a href="#" class="text-white font-medium">Home</a>
				<a href="/" class="text-white  font-medium">About Us</a>
				<a href="/" class="text-white  font-medium">Features</a>
				<a href="/" class="text-white  font-medium">Solution</a>
			</div>

			<!-- Mobile Menu Button -->
			<div class="md:hidden">
				<button
					class="text-white focus:outline-none focus:text-mainOrange"
					on:click={toggleMenu}
				>
					<svg
						class="h-6 w-6"
						xmlns="http://www.w3.org/2000/svg"
						fill="none"
						viewBox="0 0 24 24"
						stroke="currentColor"
					>
						{#if isOpen}
							<path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
						{:else}
							<path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
						{/if}
					</svg>
				</button>
			</div>
		</div>
	</div>

	<!-- Mobile Menu -->
	{#if isOpen}
		<div class="md:hidden bg-black border-t border-white-200">
			<a href="#" class="block px-4 py-2 text-white hover:bg-mainOrange hover:text-white">Home</a>
			<a href="/" class="block px-4 py-2 text-white hover:bg-mainOrange hover:text-white">About Us</a>
			<a href="/" class="block px-4 py-2 text-white hover:bg-mainOrange hover:text-white">Features</a>
			<a href="/" class="block px-4 py-2 text-white hover:bg-mainOrange hover:text-white">Solution</a>
		</div>
	{/if}
</nav>

