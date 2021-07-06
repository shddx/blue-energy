<template>
  <nav aria-label="contract navigation">
    <ul class="pagination">
      <li class="page-item" :class="{disabled: activePage === 1}">
        <span class="page-link" @click="setActivePage(1)">&laquo;</span>
      </li>
      <li class="page-item" :class="{disabled: activePage === 1}">
        <span class="page-link" @click="setActivePage(activePage - 1)">&lsaquo;</span>
      </li>

      <li class="page-item" v-for="pageNum in rangeWithDots.values()" :key="pageNum"
          :class="{active: active(pageNum)}">
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

<script setup="props" lang="ts">
import { computed, defineEmit, defineProps, toRefs } from "vue";

const delta = 1;

const props = defineProps<{
  totalPages: number,
  activePage: number
}>();

const { totalPages } = toRefs(props);
const { activePage } = toRefs(props);

const active = (index: number) => activePage.value === index

const left = computed(() => activePage.value - delta);
const right = computed(() => activePage.value + delta + 1);

let range = computed(() => {
  let range = []
  for (let i = 1; i <= totalPages.value; i++) {
    if (i === 1 || i === totalPages.value || i >= left.value && i < right.value) {
      range.push(i);
    }
  }
  return range;
});

const rangeWithDots = computed(() => {
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
});

const emit = defineEmit<{
  (e: 'changeActivePage', num: number): void
}>()

function setActivePage (num: number) {
  emit('changeActivePage', num)
}

</script>

<style scoped>

</style>
