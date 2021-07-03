<template>
  <div class="c-sidebar c-sidebar-dark c-sidebar-fixed" :class="{'c-sidebar-minimized': sidebarMinimized, 'c-sidebar-show': sidebarShow}">
    <ul class="c-sidebar-nav">
      <li class="c-sidebar-nav-title">Nav Title</li>
      <li class="c-sidebar-nav-item">
        <router-link class="c-sidebar-nav-link" to="/contracts">
          <i class="c-sidebar-nav-icon cil-description"></i> Договора
        </router-link>
      </li>
      <li class="c-sidebar-nav-item">
        <router-link class="c-sidebar-nav-link" to="/houses">
          <i class="c-sidebar-nav-icon cil-house"></i> Дома
        </router-link>
      </li>
      <li class="c-sidebar-nav-item c-sidebar-nav-dropdown">
        <a class="c-sidebar-nav-link c-sidebar-nav-dropdown-toggle" href="#">
          <i class="c-sidebar-nav-icon cil-description"></i> Открывающийся список
        </a>
        <ul class="c-sidebar-nav-dropdown-items">
          <li class="c-sidebar-nav-item">
            <a class="c-sidebar-nav-link" href="#">
              <i class="c-sidebar-nav-icon cil-description"></i> Объект списка
            </a>
          </li>
        </ul>
      </li>
    </ul>
    <button class="c-sidebar-minimizer c-brand-minimizer" type="button" @click="toggleSidebarMinimized"></button>
  </div>
</template>

<script lang="ts">
import { mapActions, mapGetters, mapState } from "vuex";

export default {
  name: "Sidebar",
  data () {
    return {

    }
  },
  computed: {
    ...mapState([
      'sidebarShow',
      'sidebarMinimized'
    ])
  },
  methods: {
    ...mapActions([
      'toggleSidebarMinimized'
    ])
  }
}
</script>

<style scoped>

</style>
