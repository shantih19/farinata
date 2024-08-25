package xyz.shantih19.farinata.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FarinataBlock extends Block {

    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 4);

    public static final VoxelShape sliceOne = Shapes.join(
            Shapes.box(0.125, 0.0, 0.125, 0.5, 0.0625, 0.5),
            Shapes.join(
                    Shapes.box(0.3125, 0.0, 0.0, 0.5, 0.0625, 0.125),
                    Shapes.join(
                            Shapes.box(0.0, 0.0, 0.3125, 0.125, 0.0625, 0.5),
                            Shapes.join(
                                    Shapes.box(0.1875, 0.0, 0.0625, 0.3125, 0.0625, 0.125),
                                    Shapes.box(0.0625, 0.0, 0.1875, 0.125, 0.0625, 0.3125), BooleanOp.OR
                            ),
                            BooleanOp.OR),
                    BooleanOp.OR
            ),
            BooleanOp.OR);

    public static final VoxelShape sliceTwo = Shapes.join(
            sliceOne,
            Shapes.join(
                    Shapes.box(0.5, 0.0, 0.125, 0.875, 0.0625, 0.5),
                    Shapes.join(
                            Shapes.box(0.875, 0.0, 0.3125, 1.0, 0.0625, 0.5),
                            Shapes.join(
                                    Shapes.box(0.5, 0.0, 0.0, 0.6875, 0.0625, 0.125),
                                    Shapes.join(
                                            Shapes.box(0.875, 0.0, 0.1875, 0.9375, 0.0625, 0.3125),
                                            Shapes.box(0.6875, 0.0, 0.0625, 0.8125, 0.0625, 0.125), BooleanOp.OR
                                    ),
                                    BooleanOp.OR),
                            BooleanOp.OR
                    ),
                    BooleanOp.OR
            ), BooleanOp.OR);

    public static final VoxelShape sliceThree = Shapes.join(
            sliceTwo,
            Shapes.join(
                    Shapes.box(0.5, 0.0, 0.5, 0.875, 0.0625, 0.875),
                    Shapes.join(
                            Shapes.box(0.5, 0.0, 0.875, 0.6875, 0.0625, 1.0),
                            Shapes.join(
                                    Shapes.box(0.875, 0.0, 0.5, 1.0, 0.0625, 0.6875),
                                    Shapes.join(
                                            Shapes.box(0.6875, 0.0, 0.875, 0.8125, 0.0625, 0.9375),
                                            Shapes.box(0.875, 0.0, 0.6875, 0.9375, 0.0625, 0.8125), BooleanOp.OR
                                    ),
                                    BooleanOp.OR),
                            BooleanOp.OR
                    ),
                    BooleanOp.OR
            ), BooleanOp.OR);

    public static final VoxelShape sliceFour = Shapes.join(
            sliceThree,
            Shapes.join(
                    Shapes.box(0.125, 0.0, 0.5, 0.5, 0.0625, 0.875),
                    Shapes.join(
                            Shapes.box(0.0, 0.0, 0.5, 0.125, 0.0625, 0.6875),
                            Shapes.join(
                                    Shapes.box(0.3125, 0.0, 0.875, 0.5, 0.0625, 1.0),
                                    Shapes.join(
                                            Shapes.box(0.0625, 0.0, 0.6875, 0.125, 0.0625, 0.8125),
                                            Shapes.box(0.1875, 0.0, 0.875, 0.3125, 0.0625, 0.9375), BooleanOp.OR
                                    ),
                                    BooleanOp.OR),
                            BooleanOp.OR
                    ),
                    BooleanOp.OR
            ), BooleanOp.OR);

    public static final VoxelShape[] SHAPE_BY_BITES = new VoxelShape[]{
            sliceOne, sliceOne, sliceTwo, sliceThree, sliceFour
    };

    public FarinataBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(
                this.getStateDefinition().any().setValue(BITES, 4)
        );
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        int bites = blockState.getValue(BITES);
        if (bites > 0) {
            FoodData food = player.getFoodData();
            food.eat(3, 4f);
            if ( (bites - 1) <= 0 ) {
                    level.destroyBlock(blockPos, false);
            } else {
                blockState = blockState.setValue(BITES, bites - 1);
                level.setBlockAndUpdate(blockPos, blockState);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_BITES[this.withPropertiesOf(pState).getValue(BITES)];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }
}
