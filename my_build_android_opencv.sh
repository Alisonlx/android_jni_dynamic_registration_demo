cd opencv
rm -rf build/
ABI="arm64-v8a"
echo "building for $ABI"
mkdir -p build
cd build/
cmake \
  -DCMAKE_TOOLCHAIN_FILE=${ANDROID_NDK}/build/cmake/android.toolchain.cmake \
  -DANDROID_TOOLCHAIN=clang++ \
  -DANDROID_ABI=$ABI \
  -D CMAKE_BUILD_TYPE=Debug \
  -D ANDROID_NATIVE_API_LEVEL=24 \
  -D WITH_CUDA=OFF \
  -D WITH_MATLAB=OFF \
  -D BUILD_ANDROID_EXAMPLES=OFF \
  -D BUILD_DOCS=OFF \
  -D BUILD_PERF_TESTS=OFF \
  -D BUILD_TESTS=OFF \
  -D ANDROID_STL=c++_shared \
  -D BUILD_SHARED_LIBS=ON \
  -D BUILD_opencv_objdetect=OFF \
  -D BUILD_opencv_video=OFF \
  -D BUILD_opencv_videoio=OFF \
  -D BUILD_opencv_features2d=OFF \
  -D BUILD_opencv_flann=OFF \
  -D BUILD_opencv_highgui=ON \
  -D BUILD_opencv_ml=ON \
  -D BUILD_opencv_photo=OFF \
  -D BUILD_opencv_python=OFF \
  -D BUILD_opencv_shape=OFF \
  -D BUILD_opencv_stitching=OFF \
  -D BUILD_opencv_superres=OFF \
  -D BUILD_opencv_ts=OFF \
  -D BUILD_opencv_videostab=OFF \
  -DBUILD_TESTING=OFF \
  -DBUILD_PERF_TESTS=OFF \
  -DBUILD_TESTS=OFF \
  -DCMAKE_INSTALL_PREFIX:PATH=/home/alison/Chopper/3rd_party/opencv/${ABI} \
  -DBUILD_ANDROID_PROJECTS=OFF ..

make -j$(nproc)

make install

