module.exports = {
    purge: [
        './src/**/*.js',
        './src/**/*.ts',
        './src/**/*.vue',
        './src/**/*.jsx',
        './src/**/*.tsx'
    ],
    darkMode: false, // or 'media' or 'class'
    theme: {
        extend: {
            transitionProperty: {
                'height': 'height',
                'width': 'width'
            }
        }
    },
    variants: {
        extend: {},
    },
    plugins: [],
}
