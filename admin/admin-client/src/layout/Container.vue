<template>
  <div class="c-app">
    <Sidebar />
    <div class="c-wrapper" >
      <Header />
      <Breadcrumbs />
        <div class="c-body" >
          <main class="c-main">
            <div class="container-fluid">
              <div class="fade-in">
                <router-view :key="$route.path"></router-view>
              </div>
            </div>
          </main>
          <Footer />
        </div>
    </div>
  </div>
</template>

<script lang="ts">
import Sidebar from "./Sidebar.vue";
import Header from "./Header.vue";
import Footer from "./Footer.vue";
import Breadcrumbs from "@/layout/Breadcrumbs.vue";
export default {
  name: "Container",
  components: {Breadcrumbs, Footer, Header, Sidebar}
}
</script>

<style scoped>

</style>
