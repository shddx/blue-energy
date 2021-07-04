<template>
  <nav aria-label="contract navigation">
    <ul class="pagination">
      <li class="page-item" :class="{disabled: activePage === 1}">
        <span class="page-link" @click="setActivePage(1)">&laquo;</span>
      </li>
      <li class="page-item" :class="{disabled: activePage === 1}">
        <span class="page-link" @click="setActivePage(activePage - 1)">&lsaquo;</span>
      </li>


            <li class="page-item" v-for="pageNum in rangeWithDots" :key="pageNum" :class="{active: activePage === pageNum}">
              <span class="page-link" @click="setActivePage(pageNum)">{{ pageNum }}</span>
            </li>

<!--      <li class="page-item" :class="{active: activePage === 1}" v-if="before">-->
<!--        <span class="page-link" @click="setActivePage(1)">{{ 1 }}</span>-->
<!--      </li>-->

<!--      <li role="separator" class="page-item" v-if="before">-->
<!--        <span class="page-link">…</span>-->
<!--      </li>-->

<!--      <li class="page-item" v-for="pageNum in pageNums" :key="pageNum" :class="{active: activePage === pageNum}">-->
<!--        <span class="page-link" @click="setActivePage(pageNum)">{{ pageNum }}</span>-->
<!--      </li>-->

<!--      <li role="separator" class="page-item" v-if="dotsAfter">-->
<!--        <span class="page-link">…</span>-->
<!--      </li>-->

<!--      <li class="page-item" :class="{active: activePage === totalPages}" v-if="isBigPanel">-->
<!--        <span class="page-link" @click="setActivePage(totalPages)">{{ totalPages }}</span>-->
<!--      </li>-->

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
import {mapState} from "vuex";

export default {
  name: "Pagination",
  props: {},
  data() {
    return {
      delta: {
        type: Number,
        default: 1
      }
    }
  },
  computed: {
    ...mapState([
      'totalPages',
      'activePage'
    ]),
    left(): number {
      return this.activePage - this.delta;
    },
    right() {
      return this.activePage + this.delta + 1;
    },
    range() {
      let range = []
      for (let i = 1; i <= this.totalPages; i++) {
        if (i === 1 || i === this.totalPages || i >= this.left && i < this.right) {
          range.push(i);
        }
      }
      return range;
    },
    rangeWithDots() {
      let temp;
      let rangeWithDots = []
      for (let i of this.range) {
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
    }
  },
  methods: {
    setActivePage(num) {
      this.$store.dispatch('fetchContracts', num)
    }
  }
}
</script>

<style scoped>

</style>
