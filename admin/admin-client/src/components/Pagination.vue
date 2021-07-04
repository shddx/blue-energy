<template>
  <nav aria-label="contract navigation">
    <ul class="pagination">
      <li class="page-item" :class="{disabled: activePage === 1}">
        <span class="page-link" @click="setActivePage(1)">&laquo;</span>
      </li>
      <li class="page-item" :class="{disabled: activePage === 1}">
        <span class="page-link" @click="setActivePage(activePage - 1)">&lsaquo;</span>
      </li>

      <li class="page-item" v-for="pageNum in rangeWithDots.values()" :key="pageNum" :class="{active: activePage === pageNum}">
        <span class="page-link" @click="setActivePage(pageNum)">{{ pageNum }}</span>
      </li>

      <li class="page-item" :class="{disabled: activePage === totalPages}">
        <span class="page-link" @click="setActivePage(activePage + 1)">&rsaquo;</span>
      </li>
      <li class="page-item" :class="{disabled: activePage === totalPages}">
        <span class="page-link" @click="setActivePage(totalPages)">&raquo;</span>
      </li>
    </ul>
  </nav>
</template>

<script lang="ts">
import { computed, defineComponent } from "vue";
import { useStore } from "vuex";
import { key } from '@/store'

export default defineComponent({
  name: "Pagination",
  setup() {
    const store = useStore(key);
    const delta = 1;
    let totalPages = computed(() => store.state.totalPages);
    let activePage = computed(() => store.state.activePage);
    let left = computed(() => activePage.value - delta);
    let right = computed(() => activePage.value + delta + 1);

    let range = computed(() => {
      let range = []
      for (let i = 1; i <= totalPages.value; i++) {
        if (i === 1 || i === totalPages.value || i >= left.value&& i < right.value) {
          range.push(i);
        }
      }
      return range;
    });
    let rangeWithDots = computed(() => {
      let temp;
      let rangeWithDots = []
      for (let i of range.value) {
        if (temp) {
          if (i - temp === 2) {
            rangeWithDots.push(temp + 1);
          } else if (i - temp !== 1) {
            rangeWithDots.push('...');
          }
        }
        rangeWithDots.push(i);
        temp = i;
      }
      return rangeWithDots;
    })

    return {
      totalPages,
      activePage,
      rangeWithDots
    }
  },
  methods: {
    setActivePage(num: number) {
      this.$store.dispatch('fetchContracts', num);
    }
  }
})

</script>

<style scoped>

</style>
